/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fsmini;
import static fsmini.FSmini.ind;
import java.io.*;
import java.util.*;
import java.time.LocalDate;
import javax.swing.*;
import static fsmini.register.stname;
import static fsmini.register.phno;
import static fsmini.register.password;
import static fsmini.batch.b1;
import static fsmini.batch.b2;
import static fsmini.batch.b3;
import static fsmini.batch.b4;
import static fsmini.feepay.fee;
import static fsmini.feepay.feep;
import static fsmini.search.pitch;
import static fsmini.search.sname;
import static fsmini.search.movie;
import static fsmini.index.username;
import static fsmini.index.lpassword;
import static fsmini.songpay.sfeep;
import static fsmini.songpay.sfee;


/**
 *
 * @author Hiranmayee
 */
public class FSmini {
    static int sid,kid,num,knum,c=0;
    static boolean flag=false;
    static String amo;
    static String buffer=new String(new char[100]);
    static String bufferf=new String(new char[100]);
    static String bufferk=new String(new char[100]);
    static String[] ind=null;
    public static class student{
        String id="0";
        String sname=new String(new char[20]);
        String password=new String(new char[10]);
        String phno=new String(new char[10]);
        String batch=new String(new char[10]);
        String date=new String(new char[15]);
        String fee=new String(new char[5]);
        student(){
            
        }
        student(String i1,String i2,String i3,String i4,String i5,String i6,String i7){
            id=i1;
            sname=i2;
            password=i3;
            phno=i4;
            date=i7;
            batch=i5;
            fee=i6;
            
        }
    }
    static student s=new student();
    static student[] st=new student[200];
    public static class karaoke{
        String id="0";
        String kname=new String(new char[30]);
        String movie=new String(new char[30]);
        String pitch=new String(new char[1]);
        String cost=new String(new char[5]);
        karaoke(){
            
        }
        karaoke(String i1,String i2,String i3,String i4,String i5){
            id=i1;
            kname=i2;
            movie=i3;
            pitch=i4;
            cost=""+i5;
        }
    }
    static karaoke kk[]=new karaoke[200];
    static void packs(){
        
        s.fee=feep.getText().toString();
        
        if(amo.equals(s.fee)){
        buffer=s.id+"|"+s.sname+"|"+s.password+"|"+s.phno+"|"+s.batch+"|"+s.fee+"|"+s.date;
        
        
        
        }
        else{
            JOptionPane.showMessageDialog(null, "You entered incorrect amount");
        }
    }
    
    static int max(){
        int max=0,n;
        for(int i=0;i<num;i++){
            n=Integer.parseInt(st[i].id);
            if(n>max)
                max=n;
        }
        return max;
    }
    static void reads(){
        
        sid=max()+1;
        s.id=""+sid;
        s.sname=stname.getText();
        LocalDate date = LocalDate.now();
        s.date=date.toString();
        s.password=String.valueOf(password.getPassword());
        s.phno=phno.getText();
        
        if(b1.isSelected()){
            s.batch="vocal";
            amo="700"; 
        }
        else if(b2.isSelected()){
            s.batch="guitar";
            amo="600";
        }
        else if(b3.isSelected()){
            s.batch="violin";
             amo="650";
        }
        else if(b4.isSelected()){
             amo="800";
             s.batch="flute";
        }
        
            
        
    }
    
    static void writes()throws IOException{
        
        packs();
        BufferedWriter bw = null;
        FileWriter fw = null;
        
        File file = new File("Z:\\6th semester\\FS miniproject\\student.txt");
                
        try{
        
        if(ind[0].equals("0")){
        try{
            
            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            
            bw.write(buffer);
            bw.newLine();
           
            st[num]=new student();
            st[num].sname=s.sname;
            st[num].password=s.password;
            st[num].phno=s.phno;
            st[num].batch=s.batch;
            st[num].date=s.date;
            st[num].fee=s.fee;
            st[num].id=s.id;
            num++;
            
            
        }catch (IOException e) {

            e.printStackTrace();

        }
        bw.close();
        fw.close();
        }
        else{
            for(int j=0;j<num;j++){
                if(ind!=null && ind[1].equals(st[j].id)){
                    st[j]=new student();
                    st[j].sname=s.sname;
                    st[j].password=s.password;
                    st[j].phno=s.phno;
                    st[j].batch=s.batch;
                    st[j].date=s.date;
                    st[j].fee=s.fee;
                    st[j].id=s.id;
                    
                    
                    for(int p=2;p<c-1;p++){
                        ind[p-1]=ind[p];
                    }
                    c--;
                    
                    ind[0]=""+(c-1); 
                    update();
                    break;
                }
                        
            }
        }
        }catch(NullPointerException n){
            n.printStackTrace();
        }
            
    }
    
    
    static void check(){
        String f=feep.getText();
        switch(s.batch){
            case "vocal":amo="700";
            break;
            case "guitar":amo="600";
            break;
            case "violin":amo="650";
            break;
            case "flute":amo="800";
            break;
        }
        try{
        if(f.equals(amo)){
        String[] parts=s.date.split("\\-");
        
        Long year=Long.parseLong(parts[0]);
        Long month=Long.parseLong(parts[1]);
        Long day=Long.parseLong(parts[2]);
        
	LocalDate date = LocalDate.now();
        String cdate=date.toString();
        String[] cparts=cdate.split("\\-");
        Long cyear=Long.parseLong(cparts[0]);
        Long cmonth=Long.parseLong(cparts[1]);
        Long cday=Long.parseLong(cparts[2]);
        flag=false;
        for(int j=0;j<num;j++){
            Integer i=Integer.parseInt(st[j].id);
            Integer z=new Integer(s.id);
            
            if(i.equals(z)){
                flag=true;
                break;
            }
                
        }
           if(flag==false){
                try{
                
               
                writes();
                packf();
                return;
            }
            catch(IOException e){
                e.printStackTrace();
            }
           }
               
        
        
        if(month==cmonth-1){
            
            packf();
            
        }
            
        else if(year==cyear-1&&cmonth==1&&month==12){
            
            packf();
        }
        else
             JOptionPane.showMessageDialog(null, "you have paid the fee for this month");
        }else
             JOptionPane.showMessageDialog(null, "you have entered incorrect amount");
    }catch(NumberFormatException n){
            n.printStackTrace();
        }
    }
    static void packf(){
       String f=feep.getText();
       
	LocalDate date = LocalDate.now();
        
        
       bufferf=""+sid+"|"+s.batch+"|"+date+"|"+f;
       try{
        writef();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    
    static void writef()throws IOException{
        
        
        BufferedWriter bw = null;
        FileWriter fw = null;
        File file = new File("Z:\\6th semester\\FS miniproject\\Fees.txt");
        try{
            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            bw.write(bufferf);
            bw.newLine();
        }catch (IOException e) {

            e.printStackTrace();

        }
        bw.close();
        fw.close();
        
    }
    
    
    static void unpacks(){
        File file = new File("Z:\\6th semester\\FS miniproject\\student.txt"); 
        String line=null;
        c=0;
        num=0;
        File index = new File("Z:\\6th semester\\FS miniproject\\index.txt");
        

        try{
        Scanner sc = new Scanner(file);
        Scanner sc1=new Scanner(index);
        
        if(sc1.hasNextLine()){
            ind=new String[20];
        while(sc1.hasNextLine()){
            ind[c]=sc1.nextLine();
            c++;
        }
        
        while (sc.hasNextLine()){ 
            line=sc.nextLine();
        try{
            String[] items=line.split("\\|");
            
            if(items!=null){
            st[num]=new student(items[0],items[1],items[2],items[3],items[4],items[5],items[6]);
            num++;
           
            }
            }catch(NullPointerException n){
                n.printStackTrace();
            }
        catch(ArrayIndexOutOfBoundsException a){
            a.printStackTrace();
        }
        }
        }
        }catch(FileNotFoundException f){
            f.printStackTrace();
        }
        
        
    }
    static void unpackk(){
        File file = new File("Z:\\6th semester\\FS miniproject\\songs.txt"); 
        String line=null;
        knum=0;
        try{
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) 
            line=sc.nextLine();
        
        try{
            String[] items=line.split("\\|");
            if(items!=null){
            kk[knum]=new karaoke(items[0],items[1],items[2],items[3],items[4]);
           
            knum++;
            }
            }catch(NullPointerException n){
                n.printStackTrace();
            }
        }
        catch(FileNotFoundException f){
            f.printStackTrace();
        }
        
    }
    static void writek()throws IOException{
        BufferedWriter bw = null;
        FileWriter fw = null;
        File file = new File("Z:\\6th semester\\FS miniproject\\songPay.txt");
        try{
            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            bw.write(bufferk);
            bw.newLine();
        }catch (IOException e) {

            e.printStackTrace();

        }
        bw.close();
        fw.close();
    }
    
    static void search(){
        int i;
        karaoke k=new karaoke();
        k.kname=sname.getText();
        k.movie=movie.getText();
        k.pitch=pitch.getText();
        for( i=0;i<knum;i++){
            if(k.kname.equals(kk[i].kname)&&k.movie.equals(kk[i].movie)&&k.pitch.equals(kk[i].pitch)){
                k.id=kk[i].id;
                LocalDate date = LocalDate.now();
                bufferk=""+sid+"|"+k.id+"|"+kk[i].cost+"|"+date;
                
                songpay sp=new songpay();
                sp.setVisible(true);
                sfee.setText(kk[i].cost);
                break;
                
            }
        }
        if(i>=knum)
            JOptionPane.showMessageDialog(null, "Karaoke not found");
    }
    
    static void costcheck(){
        String fee=sfeep.getText();
        String price=sfee.getText();
                if(fee.equals(price)){
                
                try{
                    writek();
                }
                catch(IOException e){
                    e.printStackTrace();
                }
                
                JOptionPane.showMessageDialog(null, "Karaoke will be sent to your whatsapp number");
                }
                else{
                    JOptionPane.showMessageDialog(null, "you entered incorrect amount");
                }
    }
    static void login(){
        int i;
        String checkun=username.getText();
        String checkpw=String.copyValueOf(lpassword.getPassword());
        String pass;
        for( i=0;i<num;i++){
            pass=String.valueOf(st[i].password);
            
            if(st[i].sname.equals(checkun)&&pass.equals(checkpw)){
                s.id=st[i].id;
                s.sname=checkun;
                s.batch=st[i].batch;
                s.date=st[i].date;
                home h=new home();
                h.setVisible(true);
                break;
            }
        }
        if(i>=num)
            JOptionPane.showMessageDialog(null, "Incorrect username or password");
    }
    
    static void update()throws IOException{
        BufferedWriter bw = null;
        FileWriter fw = null;
        BufferedWriter bw1 = null;
        FileWriter fw1 = null;
        File file = new File("Z:\\6th semester\\FS miniproject\\student.txt");
        File index = new File("Z:\\6th semester\\FS miniproject\\index.txt");
        try{
            fw = new FileWriter(file,false);
            bw = new BufferedWriter(fw);
            
            for(int i=0;i<num;i++){
               
                buffer=st[i].id+"|"+st[i].sname+"|"+st[i].password+"|"+st[i].phno+"|"+st[i].batch+"|"+st[i].fee+"|"+st[i].date;
                bw.write(buffer);
                bw.newLine();
            }
            
            fw1 = new FileWriter(index,false);
            bw1 = new BufferedWriter(fw1);
            
            for(int q=0;q<c;q++){
            bw1.write(ind[q]);
            bw1.newLine();
            }
        }catch (IOException e) {

            e.printStackTrace();

        }
            
        bw1.close();
        fw1.close();
        bw.close();
        fw.close();
    }
    static void del()throws IOException,NullPointerException{
        
        for(int i=0;i<num;i++){
            if(s.id.equals(st[i].id)){
                st[i].sname="***";
                ind[c]=s.id;
                c++;
                ind[0]=""+(c-1); 
                update();
                break;
                
            }
            
        }
        
        JOptionPane.showMessageDialog(null, "Your details are deleted");
        welcome w=new welcome();
        w.setVisible(true);
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
