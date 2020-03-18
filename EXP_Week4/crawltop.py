import requests
from bs4 import BeautifulSoup
import time
import os
import sys


def request_douban(url):
    headers = {'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.131 Safari/537.36'}
    cookies = {'cookie': 'bid=tVZlMsLsObQ; douban-fav-remind=1; ll="118159"; __yadk_uid=Kv7pJ6tBsux6BqgqpMU4AY7Y8kPmvYKh; _vwo_uuid_v2=D0F3CA0778A2165EAEF508F4C18E1B0B2|df933ddef03aa1d1b9cf9474442fed85; trc_cookie_storage=taboola%2520global%253Auser-id%3Ddd757902-7260-42e7-bf45-c0be7aa5052e-tuct32086cd; viewed="1048931"; gr_user_id=fcbfd1a5-0d44-4cdd-9613-cb734a482661; __utmc=30149280; __utmc=223695111; __gads=ID=408284a4f75ea2db:T=1557366480:S=ALNI_MbG0YDk6-cAN1q6DUmjIWXwUCm25Q; ck=jvZy; _pk_ref.100001.4cf6=%5B%22%22%2C%22%22%2C1557392350%2C%22https%3A%2F%2Faccounts.douban.com%2Fpassport%2Flogin%3Fredir%3Dhttps%253A%252F%252Fmovie.douban.com%252Ftop250%253Fstart%253D0%2526filter%253D%22%5D; _pk_ses.100001.4cf6=*; __utma=30149280.1245306331.1544528330.1557390340.1557392350.29; __utmb=30149280.0.10.1557392350; __utmz=30149280.1557392350.29.24.utmcsr=accounts.douban.com|utmccn=(referral)|utmcmd=referral|utmcct=/passport/login; __utma=223695111.119764156.1547904982.1557390340.1557392350.19; __utmb=223695111.0.10.1557392350; __utmz=223695111.1557392350.19.15.utmcsr=accounts.douban.com|utmccn=(referral)|utmcmd=referral|utmcct=/passport/login; push_noty_num=0; push_doumail_num=0; _pk_id.100001.4cf6=0830899ff7c63f7e.1547904984.20.1557393692.1557390340.'}
    cyheaders = {'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.131 Safari/537.36'}
    cycookies = {'cookie': 'bid=7p3I_vBkH_U; ll="118159"; _vwo_uuid_v2=D99204AB0C62530B84E1BF8DE8683C0D2|af9b00a37f235754699c89b75154fb01; douban-fav-remind=1; gr_user_id=ff2077b4-543d-42de-8539-3ddf3953ad56; viewed="30439891_30389739"; ap_v=0,6.0; ck=D520; push_noty_num=0; push_doumail_num=0'}
    try:
        response = requests.get(url, headers=cyheaders, cookies=cycookies)
        #response = requests.get(url)
        if response.status_code == 200:
            return response.text
    except requests.RequestException:
        return None

n = 1


def saveToEveryFile(soup, *parm):
    if soup.find(class_= 'all hidden') is not None:
        intro = soup.find(class_='all hidden').get_text().replace(u' ','')
    else:
        intro = soup.find(property='v:summary').get_text().replace(u' ','')
    item_director = soup.find(text='导演').parent.parent.find(class_='attrs').get_text().strip()
    itemkind = ''
    for i in soup.find_all(property='v:genre'):
        itemkind = itemkind + ' ' + i.get_text().strip()
    myPath = os.path.join(os.getcwd(), "exp" + os.sep + "data" + os.sep + "movie" + str(n) + ".txt")  # windows下去掉exp + os.sep +
    myfile = open(myPath, "w", encoding='utf-8')
    for item in parm:
        myfile.write(item)
    myfile.write("导演:" + item_director + "\n")
    myfile.write('类型:' + itemkind + '\n')
    myfile.write(intro+"\n")


def saveToFile(soup):
    myfile = open("douban.txt", "a+", encoding='utf-8')
    list = soup.find(class_='grid_view').find_all('li')
    for item in list:
        item_url = item.find('a').get('href')
        item_name = item.find(class_='title').string
        item_img = item.find('a').find('img').get('src')
        item_index = item.find(class_='').string
        item_score = item.find(class_='rating_num').string
        item_author = item.find('p').text
        if (item.find(class_='inq') != None):
            item_intr = item.find(class_='inq').string

        # print('爬取电影：' + item_index + ' | ' + item_name +' | ' + item_img +' | ' + item_score +' | ' + item_author +' | ' + item_intr )
#        print('爬取电影：' + item_index + ' | ' + item_name + ' | ' + item_score + ' | ' + item_intr)

        global n

        pageHtml = request_douban(item_url)
        pageSoup = BeautifulSoup(pageHtml, 'lxml')
        # print(pageSoup)
        saveToEveryFile(pageSoup, "影片名称:" + item_name.strip(), "影片序号:" + item_index.strip(),"豆瓣分数:" + item_score.strip())
        myfile.write(item_url + " | " + item_name + ":" + item_intr + "\n")
        n = n + 1
        time.sleep(5)

def main(page):
    url = 'https://movie.douban.com/top250?start=' + str(page * 25) + '&filter='
    html = request_douban(url)
    soup = BeautifulSoup(html, 'lxml')
    saveToFile(soup)

if __name__ == '__main__':
    for i in range(9, 10):
        main(i)
