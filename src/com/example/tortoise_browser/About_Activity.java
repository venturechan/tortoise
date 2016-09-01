package com.example.tortoise_browser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.Toast;

public class About_Activity extends Activity {
	private EditText et;
	private WebView webview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);
		et = (EditText) findViewById(R.id.et);
		webview = (WebView) findViewById(R.id.wv);
		Intent intent = getIntent();
		String string = intent.getData().toString();
		Toast.makeText(this, string+"as", Toast.LENGTH_SHORT).show();
		et.setText(string);
		//没有网络，怎么检测有没有网络
		webview.loadUrl(string);
	}
}
