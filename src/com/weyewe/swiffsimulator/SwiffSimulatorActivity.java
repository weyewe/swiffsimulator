package com.weyewe.swiffsimulator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SwiffSimulatorActivity extends Activity {
    /** Called when the activity is first created. */
	TextView promptPayment ; 
	Button executePayment; 
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        promptPayment = (TextView) findViewById(R.id.promptPaymentTextView);
        
        
        executePayment = (Button) findViewById(R.id.executePayment);
        promptPayment.setText( assembleTextFromIntentObject() );
        
        executePayment.setOnClickListener( new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				// return to the god damned calling app, give the status of the payment 
				// true? false? 
				
				
				Intent result = new Intent();
				
				result.putExtra("transaction_response_code", "999");
				setResult( RESULT_OK, result );
				finish(); // return to the calling activity
			}
        });
    }
    
    private String assembleTextFromIntentObject(){
    	Bundle extras = getIntent().getExtras();
    	StringBuilder stringBuilder = new StringBuilder("");
    	
    	if( extras != null ) {
    		String invoiceId = extras.getString("invoice_id");
    		stringBuilder.append("Invoice: " + invoiceId + "\n");
    		
    		
    		String totalCost = extras.getString("total_cost");
    		stringBuilder.append("Total: " + totalCost+ "\n");
    
    	}else{
    		stringBuilder.append("Hahaha brother, no intent object");
    	}
    	
    	return stringBuilder.toString(); 
    }
}