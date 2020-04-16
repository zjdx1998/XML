xmlGroup = null;
function renderGroupPage(xmlGroup=null) {
    if(!xmlGroup) xmlGroup = loadXmlFile("./GroupInfo.xml");
    members = xmlGroup.getElementsByTagName("member");
    let main = document.getElementsByTagName('grouppanel')[0];   
    main.innerHTML = "";
    for(let member of members){     
        para=document.createElement("name");
        para.innerHTML=member.getElementsByTagName("name")[0].childNodes[0].nodeValue + "<br/>";
        main.appendChild(para);     
        para=document.createElement("email");
        para.innerHTML=member.getElementsByTagName("Contact")[0].childNodes[0].nodeValue + "<br/>";
        main.appendChild(para);
    }
}

function modifyEmail() {
    xmlGroup = loadXmlFile("./GroupInfo.xml")
    let name = prompt('您要修改谁的邮箱啊?', '你猜');
    let _change = prompt('那您要修改成什么啊?', '110@seu.edu.cn');
    var namezjd = "张建东", namezz="湛钊";
    if (name != namezjd && name != namezz) return;
    x = xmlGroup.getElementsByTagName("member");
    for(let child of x){
        if (child.getElementsByTagName("name")[0].childNodes[0].nodeValue.trim()==name){
            child.getElementsByTagName("Contact")[0].childNodes[0].nodeValue=_change;
        }
    }
    renderGroupPage(xmlGroup);
}
function addEmail() {
    if (!xmlGroup) xmlGroup = loadXmlFile("./GroupInfo.xml")
    let name = prompt('您要增加谁的邮箱啊?', '你猜');
    let _change = prompt('那您要增加什么啊?', '110@seu.edu.cn');
    var namezjd = "张建东", namezz="湛钊";
    if (name != namezjd && name != namezz) return;
    x = xmlGroup.getElementsByTagName("member");
    for(let child of x){
        if (child.getElementsByTagName("name")[0].childNodes[0].nodeValue.trim()==name){
            child.getElementsByTagName("Contact")[0].childNodes[0].nodeValue+=(" "+_change);
        }
    }
    renderGroupPage(xmlGroup);
    xmlGroup = xmlGroup;
}

function getVal(x, cate){
    return x.getElementsByTagName(cate)[0].childNodes[0].nodeValue;
}

function out(movList){
    let main = document.getElementById("LeftPart");
    main.innerHTML="";
    for(let mov of movList){
        main.innerHTML += "<p style='font-size:20px;color:Yellow'>" + getVal(mov,"StandardName") + "</p> Date: " + getVal(mov,"Date")
             + "<br/>Length: " + getVal(mov,"Length") + "<br/>Rating: " + getVal(mov,"Rating") + "<br/><hr/>"
    }
}

function swapNode(node1,node2){
    var parent=node1.parentNode;
    var t1=node1.nextSibling;
    var t2=node2.nextSibling;
    if(t1) parent.insertBefore(node2,t1);
    else parent.appendChild(node2);
    if(t2) parent.insertBefore(node1,t2);
    else parent.appendChild(node1);
}

function sort(){
    let category = prompt("请选择排序种类: Date, Length, Rating", "Rating");
    dbMoviesFile = loadXmlFile("./doubanMovie.xml")
    movieList = dbMoviesFile.getElementsByTagName("Movie");
    let n = movieList.length;
    for(let i = 0; i<n; i++)
        for(let j=0;j<n-i-1;j++)    
            if(getVal(movieList[j],category)>getVal(movieList[j+1],category)){
                swapNode(movieList[j],movieList[j+1]);
            }
    out(movieList);
}