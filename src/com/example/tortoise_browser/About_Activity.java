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
			//我新添加的代码2016-09-01-AboutActivity
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);
		et = (EditText) findViewById(R.id.et);
		webview = (WebView) findViewById(R.id.wv);
		Intent intent = getIntent();
		String string = intent.getData().toString();
		Toast.makeText(this, string+"as", Toast.LENGTH_SHORT).show();
		et.setText(string);
		//没有网络，怎么检测有没有网络
<<<<<<< 1a619acddbe458ce17bd72368686221d639fd135
		//aaa
=======
		//这里你这里的代码写得没那么好，我觉得这样子写更好！
		//核心代码实现！
>>>>>>> 淇敼浜嗗埆浜虹殑婧愮爜
		webview.loadUrl(string);
	}
}
