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
			//������ӵĴ���2016-09-01-AboutActivity
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);
		et = (EditText) findViewById(R.id.et);
		webview = (WebView) findViewById(R.id.wv);
		Intent intent = getIntent();
		String string = intent.getData().toString();
		Toast.makeText(this, string+"as", Toast.LENGTH_SHORT).show();
		et.setText(string);
		//û�����磬��ô�����û������
<<<<<<< 1a619acddbe458ce17bd72368686221d639fd135
		//aaa
=======
		//����������Ĵ���д��û��ô�ã��Ҿ���������д���ã�
		//���Ĵ���ʵ�֣�
>>>>>>> 修改了别人的源码
		webview.loadUrl(string);
	}
}
