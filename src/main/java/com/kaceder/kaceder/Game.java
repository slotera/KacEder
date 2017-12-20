package com.kaceder.kaceder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Game extends Activity {
	 
	  public final static String EXTRA_MESSAGE = "com.example.kaceder.MESSAGE";
	  CountDownTimer timey;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		Random rnd = new Random();
        int sayi1=0,sayi2=0,islem,buttonsecim,sonuc=0;
        Intent intent = getIntent();
        String message = intent.getStringExtra(Seviye.EXTRA_MESSAGE);
        
		int sonuclarislem;
        final TextView islemm =(TextView) findViewById(R.id.textViewislem);
        final TextView sayi11 = (TextView) findViewById(R.id.textView1);
        final TextView sayi22 = (TextView) findViewById(R.id.TextView01);
        final Button sonuc1 =(Button) findViewById(R.id.button1); 
        final Button sonuc2 =(Button) findViewById(R.id.button2); 
        final Button sonuc3 =(Button) findViewById(R.id.button3); 
        final TextView puan =(TextView) findViewById(R.id.textViewpuan); 
        puan.setText(String.valueOf(Integer.parseInt(message)));
       
        int seviye = Integer.parseInt(intent.getStringExtra("seviye"));
        /* Seviyeye Gore Rasgele sayi uretimi */
        if (seviye==1) {
        	 sayi1 = rnd.nextInt(11);
             sayi2 = rnd.nextInt(11);
		}else if (seviye==2){
			sayi1 = rnd.nextInt(101);
            sayi2 = rnd.nextInt(101);
		}else if (seviye==3){
			sayi1 = 500+rnd.nextInt(1001);
            sayi2 = 500+rnd.nextInt(1001);
		}
        
    
        /* islamin rasgele uretimi */
        islem = rnd.nextInt(3);
        /* gercek cevap haricindeki seceneklerin rasgele olusumu */
        sonuclarislem = rnd.nextInt(3);
        /* gercek cevabin konumunun rasgele secilmesi */
        buttonsecim = rnd.nextInt(3);
      
        /*Sayilarin Text Halleri */
        sayi11.setText(String.valueOf(sayi1));
        sayi22.setText(String.valueOf(sayi2));
        
        /* sonucun bulunmasi ve islemin yazilmasi*/ 
        if (islem == 0)
        {
        	sonuc = sayi1 + sayi2; 
        	islemm.setText("+");
        }
        if(islem == 1)
        {
        	sonuc = sayi1 - sayi2;
        	islemm.setText("-");
        }
        if(islem == 2)
        {
        	sonuc = sayi1 * sayi2;
        	islemm.setText("x");
        }
        
       
        if(buttonsecim == 0)
    	{
    		sonuc1.setText(String.valueOf(sonuc));
    		if (sonuclarislem==0)
    		{
    			sonuc2.setText(String.valueOf(sonuc+1));
    			sonuc3.setText(String.valueOf(sonuc+2));
    		}
    		if (sonuclarislem==1)
    		{
    			sonuc2.setText(String.valueOf(sonuc-1));
    			sonuc3.setText(String.valueOf(sonuc-2));
    		}
    		if(sonuclarislem==2)
    		{
    			sonuc2.setText(String.valueOf(sonuc-1));
    			sonuc3.setText(String.valueOf(sonuc+1));
    		}
    		
    	} 
    	if(buttonsecim==1)
    	{
    		sonuc2.setText(String.valueOf(sonuc));
    		if (sonuclarislem==0)
    		{
    			sonuc1.setText(String.valueOf(sonuc+1));
    			sonuc3.setText(String.valueOf(sonuc+2));
    		}
    		if (sonuclarislem==1)
    		{
    			sonuc1.setText(String.valueOf(sonuc-1));
    			sonuc3.setText(String.valueOf(sonuc-2));
    		}
    		if(sonuclarislem==2)
    		{
    			sonuc1.setText(String.valueOf(sonuc-1));
    			sonuc3.setText(String.valueOf(sonuc+1));
    		}
    	}
    	if(buttonsecim==2)
    	{
    		sonuc3.setText(String.valueOf(sonuc));
    		if (sonuclarislem==0)
    		{
    			sonuc1.setText(String.valueOf(sonuc+1));
    			sonuc2.setText(String.valueOf(sonuc+2));
    		}
    		if (sonuclarislem==1)
    		{
    			sonuc1.setText(String.valueOf(sonuc-1));
    			sonuc2.setText(String.valueOf(sonuc-2));
    		}
    		if(sonuclarislem==2)
    		{
    			sonuc1.setText(String.valueOf(sonuc-1));
    			sonuc2.setText(String.valueOf(sonuc+1));
    		}
    	}
    	final int sonucu=sonuc;
    	
    	timey = new CountDownTimer(4000, 600) {
    		 final TextView zaman =(TextView) findViewById(R.id.textViewzaman); 
   	     public void onTick(long millisUntilFinished) {
   	    	
   	 		zaman.setText(String.valueOf(Integer.parseInt((String) zaman.getText())-1));
   	 		//zamani yazdirma
   	     }

   	     public void onFinish() {
   	    	 final TextView puan =(TextView) findViewById(R.id.textViewpuan); 
   	    	zaman.setText(String.valueOf(Integer.parseInt((String) zaman.getText())-1));
   	    	 		Intent i = new Intent(Game.this,Puan.class);
   	    	 	i.putExtra("puan", puan.getText());
   	    	 		startActivity(i);
   	    	 		finish();
						//	
   	    	 
   	      }
   	     }.start();
    	
    	
    	sonuc1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(Integer.parseInt((String) sonuc1.getText())== sonucu)
				{
					
					puan.setText(String.valueOf(Integer.parseInt((String) puan.getText())+100));
				}
				else{
					
					puan.setText(String.valueOf(Integer.parseInt((String) puan.getText())-50));
					}

				if(Integer.parseInt((String) puan.getText())<0){
					puan.setText(String.valueOf(0));
					timey.onFinish();

				}else{
					Intent intent = getIntent();
					timey.cancel();
					finish();
					intent.putExtra(EXTRA_MESSAGE, String.valueOf(puan.getText()));
					startActivity(intent);

				}


			}
		});
    	sonuc2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(Integer.parseInt((String) sonuc2.getText()) == sonucu)
				{
					
					puan.setText(String.valueOf(Integer.parseInt((String) puan.getText())+100));
				}
				else{
					
					puan.setText(String.valueOf(Integer.parseInt((String) puan.getText())-50));
					}
				if(Integer.parseInt((String) puan.getText())<0){
					puan.setText(String.valueOf(0));
					timey.onFinish();

				}else{
					Intent intent = getIntent();
					timey.cancel();
					finish();
					intent.putExtra(EXTRA_MESSAGE, String.valueOf(puan.getText()));
					startActivity(intent);

				}
			}
		});
    	sonuc3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(Integer.parseInt((String) sonuc3.getText())== sonucu)
				{
					
					puan.setText(String.valueOf(Integer.parseInt((String) puan.getText())+100));
				}
				else{
					
					puan.setText(String.valueOf(Integer.parseInt((String) puan.getText())-50));
					}
				if(Integer.parseInt((String) puan.getText())<0){
					puan.setText(String.valueOf(0));
					timey.onFinish();

				}else{
					Intent intent = getIntent();
					timey.cancel();
					finish();
					intent.putExtra(EXTRA_MESSAGE, String.valueOf(puan.getText()));
					startActivity(intent);

				}
			}
		});
    	
    	
	}
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		timey.cancel();
		Intent a = new Intent(Game.this,MainActivity.class);
		startActivity(a);
		finish();
	}

	
}
