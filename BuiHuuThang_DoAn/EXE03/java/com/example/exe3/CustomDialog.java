package com.example.exe3;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class CustomDialog {

	public Context context;
	MediaPlayer sound;
	SoundClass sou;

	public CustomDialog(Context context) {
		this.context = context;
		sou = new SoundClass(context);
	}


	public void showDialog(int layout, String dialogName, String msg, String data) {
		final Dialog dialog = new Dialog(context);
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
		dialog.setContentView(layout);


		TextView message = (TextView) dialog.findViewById(R.id.message);
		message.setText(msg.trim());

		LinearLayout confirmDlg = (LinearLayout) dialog.findViewById(R.id.confirmDlg);
		LinearLayout alertDlg = (LinearLayout) dialog.findViewById(R.id.alertDlg);

		if (dialogName.equals("exitDlg")) {
			confirmDlg.setVisibility(View.VISIBLE);
			exitDlg(dialog);
		}
		if (dialogName.equals("dattienDlg")) {
			confirmDlg.setVisibility(View.VISIBLE);
			exitDlg(dialog);
		}
		dialog.setCanceledOnTouchOutside(false);
		dialog.show();
	}

	// ==============================================================================

	private void exitDlg(final Dialog dialog) {

		Button noBtn = (Button) dialog.findViewById(R.id.noBtn);

		noBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				sou.playSound(R.raw.buttons);
				dialog.dismiss();
			}
		});
		Button yesBtn = (Button) dialog.findViewById(R.id.yesBtn);
		yesBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				sou.playSound(R.raw.buttons);
				((Activity) context).finish();
				System.exit(0);
			}
		});
	}

}