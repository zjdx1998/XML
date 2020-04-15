package doubanMovie;

import com.sun.xml.internal.stream.events.EndElementEvent;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.stream.events.EndElement;

public class PickMovieHandler extends DefaultHandler{
    MovieDetail movieDetail;
    String currentQName;
    boolean saved = false;

    String StandardName;


    public PickMovieHandler(String name){
        super();
        movieDetail = new MovieDetail();
        StandardName = name;
    }

    public void randomMovie(){

    }

    public void startDocument(){
        System.out.println("startdoc");
        System.out.println("search"+StandardName);
    }

    public void endDocument(){
        System.out.println("enddoc");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//        System.out.println("start element:"+ qName);
        if(!saved) {
            currentQName = qName;
            for (int i = 0; i < attributes.getLength(); i++) {
                movieDetail.setValue(String.valueOf(attributes.getValue(i)), attributes.getQName(i));
                movieDetail.addToList(String.valueOf(attributes.getValue(i)), attributes.getQName(i));
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
//        System.out.println("end element:"+ qName);
        if(!saved&&qName.equals("Movie")){
            if(movieDetail.StandardName.substring(0,movieDetail.StandardName.indexOf("\n")).equals(StandardName)){
                saved = true;
//                System.out.println("saved"+movieDetail.StandardName );
            }else{
                movieDetail = new MovieDetail();
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
//        System.out.println(new String(ch,start,length));
        if(!saved) {
            movieDetail.setValue(new String(ch, start, length), currentQName);
            movieDetail.addToList(new String(ch, start, length), currentQName);
        }
    }
}
