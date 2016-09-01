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
		WebSettings settings = webview.getSettings();//得到 设置器对象
		settings.setJavaScriptEnabled(true);//支持javascript
		//让webview支持重定向-- 这个真是特别重要，因为基本上如果要联网的，都会牵涉到重定向
		//因为会重定向，所以以防万一
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
		//让webView回调进度，//当进度改变的时候。
		webview.setWebChromeClient(new WebChromeClient(){
			@Override
			public void onProgressChanged(WebView view, int newProgress) {
				// TODO Auto-generated method stub
				//进度条。--进度条的setWebChromeClient
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
		//View这个的功能是要怎么实现了。
		String url = ed.getText().toString().trim();
		//肯定要添加这个view啦。 肯定要联网
		//工具包
		if(TextUtils.isEmpty(url)){
			Toast.makeText(this, "请输入网址后再运行", Toast.LENGTH_SHORT).show();
		}
		webview.loadUrl(url);
	}
	//当点击
	@Override
	public void onBackPressed() {
		
		
		if(webview.canGoBack()){
			webview.goBack();
		}else{
			counter++;
			if(counter==2){
				//这个是模拟双击onbackPressed才退出，还没完善
			super.onBackPressed();
			Toast.makeText(this, "成功退出", Toast.LENGTH_SHORT).show();
			}
			onBackPressed();
		}
	}
	public void enterAboutMe(View view){
		Intent intent = new Intent();
		intent.setClass(this, About_Activity.class);
		//设置了之后呢，do what.
		intent.setData(Uri.parse("file:///android_asset/7881.html"));
		startActivity(intent);
		// file:///android_asset/7881.html
		// 资源文件，网站资源就放在这里。 asset
	}
	
	
}
