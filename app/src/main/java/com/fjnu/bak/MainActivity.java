package com.fjnu.bak;


import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.fjnu.R;
import com.fjnu.adapter.MyAdapter;
import com.fjnu.bean.ItemBean;
import com.fjnu.bean.WeatherBean;

import java.util.ArrayList;
import java.util.List;


public class MainActivity {
	private View headView;
	private String text;
	private ItemBean bean;
	private List<WeatherBean> weatherList;
	private static final String TAG = "TAG";
	private ListView mLv;
	private ObjectAnimator anim1, anim2;
	private TextView mStartInfo;
	private ImageView mImgHelp, mImgYy, centerImg;
	// 语义理解对象（语音到语义）。
	private MyAdapter mAdapter;
	private List<ItemBean> list = new ArrayList<>();
	private Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			if (msg.what == 0x123) {
				list.add(bean);
				mAdapter.notifyDataSetChanged();
			} else if (msg.what == 0x1234) {
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < weatherList.size(); i++) {
					ItemBean weather = new ItemBean();
					Log.i(TAG, "handleMessage: " + weatherList.get(i).toString());
					weather.setContent(weatherList.get(i).toString());
					list.add(weather);
					sb.append(weather.getContent());
				}
				mAdapter.notifyDataSetChanged();
				sb = null;
			} else if (msg.what == 0x12345) {
				ItemBean weather = new ItemBean();
				String answer = "你是个大帅哥";
				weather.setContent(answer);
				list.add(weather);
				mAdapter.notifyDataSetChanged();
			} else if (msg.what == 0x123456) {
				String appName = bean.getContent();
				PackageManager manager = null;
				List<PackageInfo> packageInfo = manager.getInstalledPackages(0);

				for (PackageInfo info : packageInfo) {
					String pageName = info.packageName;
					try {
						String lable = (String) manager.getApplicationLabel(manager.getApplicationInfo(pageName, PackageManager.GET_META_DATA));
						if (lable.equals(appName)) {
							Intent intent = manager.getLaunchIntentForPackage(pageName);
						}

					} catch (PackageManager.NameNotFoundException e) {
						e.printStackTrace();
					}
				}
			} else if (msg.what == 0x1234567) {
				String contentName = bean.getContent();
				String phoneNumber = callPhone(contentName);
				mAdapter.notifyDataSetChanged();

				Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumber));
			}

		}
	};

	protected void onCreate(Bundle savedInstanceState) {
		initWidgets();//初始化各控件
		mLv.addHeaderView(headView);
		initSpeechSynthesizerPar();//设置SpeechSynthesizer参数
		initSpeechUnderstanderPar();//设置SpeechUnderstander参数
		mLv.setAdapter(mAdapter);

	}

	/**
	 * 设置语音语意参数
	 */
	private void initSpeechUnderstanderPar() {
	}

	/**
	 * 初始化各控件
	 */
	private void initWidgets() {
		mImgHelp.setOnClickListener(new MyOnclick());
		mImgYy.setOnClickListener(new MyOnclick());
	}

	/**
	 * 设置语音合成的参数
	 */
	private void initSpeechSynthesizerPar() {
	}


	/**
	 * 初始化监听器（语音到语义）。
	 */
	protected void onDestroy() {
	}

	public String callPhone(String name) {
		Cursor cursor = null;
		while (cursor.moveToNext()) {
			//获取联系人ID
			String contactId = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
			//获取联系人的名字
			String contactName = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
			if (name.equals(contactName)) {
				//使用ContentResolver查找联系人的电话号码
				Cursor phone = null;
				if (phone.moveToNext()) {
					String phoneNumber = phone.getString(phone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
					return phoneNumber;
				}
			}
		}
		return name;
	}

	public class MyOnclick implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
				case R.id.yy_img:
					break;

				case R.id.help_img:

					break;


			}
		}
	}

}
