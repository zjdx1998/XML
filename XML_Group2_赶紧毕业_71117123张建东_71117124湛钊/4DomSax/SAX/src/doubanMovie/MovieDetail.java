package doubanMovie;

import java.util.Vector;

public class MovieDetail {
    public String MovieRank="";
    public String total="";
    public String Retrieve="";
    public String time="";
    public String Movie="";
    public String Rank="";
    public String Name="";
    public String StandardName="";
    public Vector OtherNameList;
    public String OtherName="";
    public String Rating="";
    public String Category="";
    public Vector CategoryList;
    public String Intro="";
    public String keyword="";
    public String Date="";
    public String Length="";
    public String Director="";
    public String ScriptWriter="";
    public Vector ScriptWriterList;
    public Vector ActorList;
    public String Actor="";

    public MovieDetail(){
        OtherNameList = new Vector();
        CategoryList = new Vector();
        ScriptWriterList = new Vector();
        ActorList = new Vector();

    }

    public void addToList(String element,String type){
        if(type.equals("OtherName")){
            if(this.OtherName!= null) {
                this.OtherNameList.add(this.OtherName);
                this.OtherName = "";
            }
        }
        if(type.equals("type")){
            if(this.Category!=null) {
                this.CategoryList.add(this.Category);
                this.Category = "";
            }
        }
        if(type.equals("ScriptWriter")){
            if(this.ScriptWriter!=null) {
                this.ScriptWriterList.add(this.ScriptWriter);
                this.ScriptWriter = "";
            }
        }
        if(type.equals("Actor")){
            if(this.Actor!=null) {
                this.ActorList.add(this.Actor);
                this.Actor = "";
            }
        }
    }
    public void setValue(String str,String type){
        if(type.equals("total")){
            total +=str;
        }
        if(type.equals("time")){
            time +=str;
        }
        if(type.equals("Rank")){
            Rank +=str;
        }
        if(type.equals("StandardName")){
            StandardName +=str;
        }
        if(type.equals("OtherName")){
            OtherName +=str;
        }
        if(type.equals("Rating")){
            Rating +=str;
        }
        if(type.equals("type")){
            Category +=str;
        }
        if(type.equals("Intro")){
            if(Intro == null) {
                Intro = str;
            }else {
                Intro +=str;
            }
        }
        if(type.equals("keyword")){
            Intro +=str;
        }
        if(type.equals("Date")){
            Date +=str;
        }
        if(type.equals("Length")){
            Length+=str;
        }
        if(type.equals("Director")){
            Director +=str;
        }
        if(type.equals("ScriptWriter")){
            ScriptWriter +=str;
        }
        if(type.equals("Actor")){
            Actor +=str;
        }
    }
//    public void clearList(){
//        OtherNameList = new Vector<String>();
//        CategoryList = new Vector<String>();
//        ScriptWriterList = new Vector<String>();
//        ActorList = new Vector<String>();
//
//    }

}
