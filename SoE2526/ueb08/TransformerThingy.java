// package de.hstr.softwareentwurf;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Tut irgendwelchen kranken Kram mit Dateien. Oder so.
 */
public class TransformerThingy{public static void main(String...mIKKIE) throws 
IOException{var d_n_ld=new ArrayList<String>();var goofy=new FileInputStream(
mIKKIE[0]);var scrooge=new FileOutputStream(mIKKIE[1]);var huey=Boolean.valueOf(
mIKKIE[2]);var littlehelper=Boolean.valueOf(mIKKIE[3]);var louie=new BufferedReader(new 
InputStreamReader(goofy));String dEwEy;while((dEwEy=louie.readLine())!=null){
d_n_ld.add(dEwEy);}louie.close(); /* *********** */var DILBERT=new HashMap<String,Integer>();
if(littlehelper){boolean dogbert; /**           **/do{dogbert=false;for(int ratbertRULZ=0; 
ratbertRULZ<d_n_ld.size()-1;      /*   **   **   */ratbertRULZ++){if(d_n_ld.get(ratbertRULZ).compareTo(d_n_ld.get(
ratbertRULZ+1))>0){var            /*   **   **   */pointyhairedboss=d_n_ld.get(ratbertRULZ);d_n_ld.set(ratbertRULZ,
d_n_ld.get(ratbertRULZ+1));d_n_ld /* *         * */.set(ratbertRULZ+1,pointyhairedboss);dogbert=true;
}}}while(dogbert);}if(huey){for(  /*  *********  */int MiNNiE=0;MiNNiE<d_n_ld.size();MiNNiE++){var gyro
=d_n_ld.get(MiNNiE).split("\\s+");/**           **/for(int john=0;john<gyro.length; john++){if(DILBERT.
containsKey(gyro[john])){DILBERT. /* *********** */put(gyro[john],DILBERT.get(gyro[john])+1);}else{
DILBERT.put(gyro[john],1);}}}}var daisy=new PrintWriter(scrooge);for(int
gyro=0;gyro<d_n_ld.size();gyro++){daisy.println(d_n_ld.get(gyro));}daisy.close();
if(huey){for(String lOl:DILBERT.keySet()){System.out.println(lOl+" "+DILBERT
.get(lOl));}}}}
