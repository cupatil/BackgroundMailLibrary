package com.kristijandraca.contactlibrarydemo;

import java.io.File;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.kristijandraca.backgroundmaillibrary.BackgroundMail;
import com.kristijandraca.backgroundmaillibrary.Utils;

public class DemoActivity extends Activity {
	Context context;
	EditText to, subject, message;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_demo);

		context = this;

		to = (EditText) findViewById(R.id.et_to);
		subject = (EditText) findViewById(R.id.et_subject);
		message = (EditText) findViewById(R.id.et_message);
		
		//DELETE THIS LINE AFTER YOU FIND YOUR ENCRPYTED PASSWORD
		Log.d("password", Utils.encryptIt("password"));
        
		Button bt_send = (Button) findViewById(R.id.bt_send);
		bt_send.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				BackgroundMail bm = new BackgroundMail(context);
				bm.setGmailUserName("your@gmail.com");
                //"DoE/GTiYpX5sz5zmTFuoHg==" is crypted "password"
				bm.setGmailPassword(Utils.decryptIt("DoE/GTiYpX5sz5zmTFuoHg==")); 
				bm.setMailTo(to.getText().toString());
				bm.setFormSubject(subject.getText().toString());
				bm.setFormBody(message.getText().toString());
				
				// this is optional
				//
				// bm.setSendingMessage("Loading...);
				// bm.setSendingMessageSuccess("Your message was sent successfully.");
				// bm.setProcessVisibility(false);
				// bm.setAttachment(Environment.getExternalStorageDirectory().getPath()+File.pathSeparator+"somefile.txt");
				bm.send();

			}

		});
	}

}
