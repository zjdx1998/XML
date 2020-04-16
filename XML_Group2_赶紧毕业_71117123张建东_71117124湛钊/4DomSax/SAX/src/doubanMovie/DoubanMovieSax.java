package doubanMovie;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DoubanMovieSax {

    File srcFile = new File("src/doubanMovie/doubanMovie.xml");

    JFrame jFrame;
    JPanel startPanel;
    JButton randButton;
    JTextField pickTextField;
    JButton pickButtion;
    JScrollPane movieDetailSPanel;
    JPanel movieDetailPanel;
    JButton backPanel;

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

//        System.out.println(randomMovieHandler.movieDetail.toString());
        DoubanMovieSax doubanMovieSax = new DoubanMovieSax();
        doubanMovieSax.init();
    }

    public void init(){
        jFrame = new JFrame("doubanMovieSax");
        jFrame.setSize(new Dimension(900,900));

        startPanel = new JPanel();
        jFrame.add(startPanel);
        pickTextField = new JTextField(50);
        pickTextField.setText("请输入电影名");
        pickButtion = new JButton("查询电影");
        randButton = new JButton("随便看看");

        startPanel.add(pickTextField, BorderLayout.WEST);
        startPanel.add(pickButtion,BorderLayout.EAST);
        startPanel.add(randButton,BorderLayout.SOUTH);




        randButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SAXParserFactory sFactory = SAXParserFactory.newInstance();

                sFactory.setValidating(false);
                SAXParser saxParser = null;
                try {
                    saxParser = sFactory.newSAXParser();
                } catch (ParserConfigurationException e1) {
                    e1.printStackTrace();
                } catch (SAXException e1) {
                    e1.printStackTrace();
                }

                XMLReader xmlReader = null;
                try {
                    xmlReader = saxParser.getXMLReader();
                } catch (SAXException e1) {
                    e1.printStackTrace();
                }

                RandomMovieHandler randomMovieHandler = new RandomMovieHandler();

                xmlReader.setContentHandler(randomMovieHandler);

                FileReader r = null;
                try {
                    r = new FileReader(srcFile);
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
                try {
                    xmlReader.parse(new InputSource(r));
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (SAXException e1) {
                    e1.printStackTrace();
                }

//                System.out.println(randomMovieHandler.movieDetail.StandardName);
                Font normalFont = new Font("Times New Roma",Font.PLAIN,15);
                movieDetailSPanel = new JScrollPane();
                movieDetailPanel = new JPanel();
                FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT,10,10);
                movieDetailPanel.setLayout(flowLayout);
                movieDetailPanel.setPreferredSize(new Dimension(800,800));
//                movieDetailPanel.setLayout(new GridLayout(8,1));
                JPanel jp1 = new JPanel();
                jp1.add(new JLabel("电影名:"));
                JLabel standardNameJL = new JLabel(randomMovieHandler.movieDetail.StandardName);
                standardNameJL.setFont(new Font("",Font.BOLD,50));
                jp1.add(standardNameJL);
                movieDetailPanel.add(jp1);
                JPanel jp2 = new JPanel();
                jp2.add(new JLabel("排名:"));
                JLabel rankJL = new JLabel(randomMovieHandler.movieDetail.Rank);
                rankJL.setFont(normalFont);
                jp2.add(rankJL);
                jp2.add(new JLabel("评分:"));
                JLabel ratingJL = new JLabel(randomMovieHandler.movieDetail.Rating);
                ratingJL.setFont(normalFont);
                jp2.add(ratingJL);
                movieDetailPanel.add(jp2);
                JPanel jp3 = new JPanel();
                jp3.add(new JLabel("别名:"));
                for(int i = 0;i<randomMovieHandler.movieDetail.OtherNameList.size();i++) {
                    JLabel OtherNameJL = new JLabel(randomMovieHandler.movieDetail.OtherNameList.get(i).toString());
                    OtherNameJL.setFont(normalFont);
                    jp3.add(OtherNameJL);
                }
                movieDetailPanel.add(jp3);
                JPanel jp4 = new JPanel();
                jp4.add(new JLabel("类别:"));
                for(int i = 0;i<randomMovieHandler.movieDetail.CategoryList.size();i++) {
                    JLabel categoryJL = new JLabel(randomMovieHandler.movieDetail.CategoryList.get(i).toString());
                    categoryJL.setFont(normalFont);
                    jp4.add(categoryJL);
                }
                movieDetailPanel.add(jp4);
                JPanel jp5 = new JPanel();
                jp5.add(new JLabel("导演:"));
                JLabel directorJL = new JLabel(randomMovieHandler.movieDetail.Director);
                directorJL.setFont(normalFont);
                jp5.add(directorJL);
                jp5.add(new JLabel("编剧:"));
                for(int i = 0;i<randomMovieHandler.movieDetail.ScriptWriterList.size();i++) {
                    JLabel scriptWriterJL = new JLabel(randomMovieHandler.movieDetail.ScriptWriterList.get(i).toString());
                    scriptWriterJL.setFont(normalFont);
                    jp5.add(scriptWriterJL);
                }
                movieDetailPanel.add(jp5);
                JPanel jp6 = new JPanel();
                jp6.setPreferredSize(new Dimension(800,150));
                jp6.setLayout(new FlowLayout(FlowLayout.LEFT));
                jp6.add(new JLabel("演员:"));
                for(int i = 0;i<randomMovieHandler.movieDetail.ActorList.size();i++) {
                    JLabel actorJL = new JLabel(randomMovieHandler.movieDetail.ActorList.get(i).toString());
                    actorJL.setFont(normalFont);
                    jp6.add(actorJL);
                }
                movieDetailPanel.add(jp6);

                JPanel jp7 = new JPanel();
                jp7.add(new JLabel("上映日期:"));
                JLabel dateJL = new JLabel(randomMovieHandler.movieDetail.Date);
                dateJL.setFont(normalFont);
                jp7.add(dateJL);

                jp7.add(new JLabel("片长:"));
                JLabel lengthJL = new JLabel(randomMovieHandler.movieDetail.Length);
                jp7.add(lengthJL);
                movieDetailPanel.add(jp7);

                JPanel jp8 = new JPanel();
                jp8.add(new JLabel("介绍:"));
                JTextArea introJL = new JTextArea();
                introJL.setText(randomMovieHandler.movieDetail.Intro);
                introJL.setLineWrap(true);
                introJL.setSize(600,200);
                introJL.setFont(normalFont);
                jp8.add(introJL);
                movieDetailPanel.add(jp8);

                jFrame.add(new JScrollPane(movieDetailPanel,
                        ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                        ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER));
                startPanel.setVisible(false);
                movieDetailPanel.setVisible(true);

            }
        });

        pickButtion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SAXParserFactory sFactory = SAXParserFactory.newInstance();

                sFactory.setValidating(false);
                SAXParser saxParser = null;
                try {
                    saxParser = sFactory.newSAXParser();
                } catch (ParserConfigurationException e1) {
                    e1.printStackTrace();
                } catch (SAXException e1) {
                    e1.printStackTrace();
                }

                XMLReader xmlReader = null;
                try {
                    xmlReader = saxParser.getXMLReader();
                } catch (SAXException e1) {
                    e1.printStackTrace();
                }

                PickMovieHandler pickMovieHandler = new PickMovieHandler(pickTextField.getText());

                xmlReader.setContentHandler(pickMovieHandler);

                FileReader r = null;
                try {
                    r = new FileReader(srcFile);
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
                try {
                    xmlReader.parse(new InputSource(r));
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (SAXException e1) {
                    e1.printStackTrace();
                }

//                System.out.println(pickMovieHandler.movieDetail.StandardName);
                Font normalFont = new Font("Times New Roma",Font.PLAIN,15);
                movieDetailSPanel = new JScrollPane();
                movieDetailPanel = new JPanel();
                FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT,10,10);
                movieDetailPanel.setLayout(flowLayout);
                movieDetailPanel.setPreferredSize(new Dimension(800,800));
//                movieDetailPanel.setLayout(new GridLayout(8,1));
                JPanel jp1 = new JPanel();
                jp1.add(new JLabel("电影名:"));
                JLabel standardNameJL = new JLabel(pickMovieHandler.movieDetail.StandardName);
                standardNameJL.setFont(new Font("",Font.BOLD,50));
                jp1.add(standardNameJL);
                movieDetailPanel.add(jp1);
                JPanel jp2 = new JPanel();
                jp2.add(new JLabel("排名:"));
                JLabel rankJL = new JLabel(pickMovieHandler.movieDetail.Rank);
                rankJL.setFont(normalFont);
                jp2.add(rankJL);
                jp2.add(new JLabel("评分:"));
                JLabel ratingJL = new JLabel(pickMovieHandler.movieDetail.Rating);
                ratingJL.setFont(normalFont);
                jp2.add(ratingJL);
                movieDetailPanel.add(jp2);
                JPanel jp3 = new JPanel();
                jp3.add(new JLabel("别名:"));
                for(int i = 0;i<pickMovieHandler.movieDetail.OtherNameList.size();i++) {
                    JLabel OtherNameJL = new JLabel(pickMovieHandler.movieDetail.OtherNameList.get(i).toString());
                    OtherNameJL.setFont(normalFont);
                    jp3.add(OtherNameJL);
                }
                movieDetailPanel.add(jp3);
                JPanel jp4 = new JPanel();
                jp4.add(new JLabel("类别:"));
                for(int i = 0;i<pickMovieHandler.movieDetail.CategoryList.size();i++) {
                    JLabel categoryJL = new JLabel(pickMovieHandler.movieDetail.CategoryList.get(i).toString());
                    categoryJL.setFont(normalFont);
                    jp4.add(categoryJL);
                }
                movieDetailPanel.add(jp4);
                JPanel jp5 = new JPanel();
                jp5.add(new JLabel("导演:"));
                JLabel directorJL = new JLabel(pickMovieHandler.movieDetail.Director);
                directorJL.setFont(normalFont);
                jp5.add(directorJL);
                jp5.add(new JLabel("编剧:"));
                for(int i = 0;i<pickMovieHandler.movieDetail.ScriptWriterList.size();i++) {
                    JLabel scriptWriterJL = new JLabel(pickMovieHandler.movieDetail.ScriptWriterList.get(i).toString());
                    scriptWriterJL.setFont(normalFont);
                    jp5.add(scriptWriterJL);
                }
                movieDetailPanel.add(jp5);
                JPanel jp6 = new JPanel();
                jp6.setPreferredSize(new Dimension(800,150));
                jp6.setLayout(new FlowLayout(FlowLayout.LEFT));
                jp6.add(new JLabel("演员:"));
                for(int i = 0;i<pickMovieHandler.movieDetail.ActorList.size();i++) {
                    JLabel actorJL = new JLabel(pickMovieHandler.movieDetail.ActorList.get(i).toString());
                    actorJL.setFont(normalFont);
                    jp6.add(actorJL);
                }
                movieDetailPanel.add(jp6);

                JPanel jp7 = new JPanel();
                jp7.add(new JLabel("上映日期:"));
                JLabel dateJL = new JLabel(pickMovieHandler.movieDetail.Date);
                dateJL.setFont(normalFont);
                jp7.add(dateJL);

                jp7.add(new JLabel("片长:"));
                JLabel lengthJL = new JLabel(pickMovieHandler.movieDetail.Length);
                jp7.add(lengthJL);
                movieDetailPanel.add(jp7);

                JPanel jp8 = new JPanel();
                jp8.add(new JLabel("介绍:"));
                JTextArea introJL = new JTextArea();
                introJL.setText(pickMovieHandler.movieDetail.Intro);
                introJL.setLineWrap(true);
                introJL.setSize(600,200);
                introJL.setFont(normalFont);
                jp8.add(introJL);
                movieDetailPanel.add(jp8);

                jFrame.add(new JScrollPane(movieDetailPanel,
                        ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                        ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER));
                startPanel.setVisible(false);
                movieDetailPanel.setVisible(true);

            }
        });


        jFrame.setVisible(true);
        startPanel.setVisible(true);

    }

}