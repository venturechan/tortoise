package com.example.tortoise_browser;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends Activity {


	private EditText ed;
	private WebView webview;
	private ProgressBar pb;
	private static int counter =0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ed = (EditText) findViewById(R.id.et);
		webview = (WebView) findViewById(R.id.wv);
		pb = (ProgressBar) findViewById(R.id.pb);
		WebSettings settings = webview.getSettings();//�õ� ����������
		settings.setJavaScriptEnabled(true);//֧��javascript
		//��webview֧���ض���-- ��������ر���Ҫ����Ϊ���������Ҫ�����ģ�����ǣ�浽�ض���
		//��Ϊ���ض��������Է���һ
		// webview.setWebViewClient
		webview.setWebViewClient(new WebViewClient(){
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// TODO Auto-generated method stub
				ed.setText(url+"aaa");
				
				webview.loadUrl(url);
				return true;
			}
		});
		//��webView�ص����ȣ�//�����ȸı��ʱ��
		webview.setWebChromeClient(new WebChromeClient(){
			@Override
			public void onProgressChanged(WebView view, int newProgress) {
				// TODO Auto-generated method stub
				//��������--��������setWebChromeClient
				if(newProgress==100){
					pb.setVisibility(pb.GONE);
				}else{
					pb.setVisibility(pb.VISIBLE);
					pb.setProgress(newProgress);
				}
			}
		});
		
	}
	public void go(View view){
		//View����Ĺ�����Ҫ��ôʵ���ˡ�
		String url = ed.getText().toString().trim();
		//�϶�Ҫ������view���� �϶�Ҫ����
		//���߰�
		if(TextUtils.isEmpty(url)){
			Toast.makeText(this, "��������ַ��������", Toast.LENGTH_SHORT).show();
		}
		webview.loadUrl(url);
	}
	//�����
	@Override
	public void onBackPressed() {
		
		
		if(webview.canGoBack()){
			webview.goBack();
		}else{
			counter++;
			if(counter==2){
				//�����ģ��˫��onbackPressed���˳�����û����
			super.onBackPressed();
			Toast.makeText(this, "�ɹ��˳�", Toast.LENGTH_SHORT).show();
			}
			onBackPressed();
		}
	}
	public void enterAboutMe(View view){
		Intent intent = new Intent();
		intent.setClass(this, About_Activity.class);
		//������֮���أ�do what.
		intent.setData(Uri.parse("file:///android_asset/7881.html"));
		startActivity(intent);
		// file:///android_asset/7881.html
		// ��Դ�ļ�����վ��Դ�ͷ������ asset
	}
	
	
}
