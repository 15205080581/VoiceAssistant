package com.fjnu;

import android.os.AsyncTask;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

//聊天机器人返回信息的接受类
public class HttpData extends AsyncTask<String, Void, String>{

	private HttpClient mHttpClient;
	private HttpGet mHttpGet;
	private HttpResponse mHttpResponse;
	private HttpEntity mHttpEntity;
	private InputStream in;
	private HttpGetDataListener listener;
	
	private String url;

	/**
	 * 构造方法
	 * @param url
	 * @param listener
	 */
	public HttpData(String url,HttpGetDataListener listener) {
		this.url = url;
		this.listener = listener;
	}

	/**
	 * 后台业务处理逻辑
	 * @param params
	 * @return
	 */
	@Override
	protected String doInBackground(String... params) {
		try {
			mHttpClient = new DefaultHttpClient();
			mHttpGet = new HttpGet(url);
			mHttpResponse = mHttpClient.execute(mHttpGet);
			mHttpEntity = mHttpResponse.getEntity();
			in = mHttpEntity.getContent();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String line;
			StringBuilder sb = new StringBuilder();
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			return sb.toString();
		} catch (Exception e) {
		}
		return null;
	}

	/**
	 * 前处理
	 * @param result
	 */
	@Override
	protected void onPostExecute(String result) {
		listener.getDataUrl(result);
		super.onPostExecute(result);
	}
}
