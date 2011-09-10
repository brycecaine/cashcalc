package com.cashcalc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class CashCalcActivity extends Activity implements OnClickListener {
	NumberPicker numberPickerBillsQty100;
	NumberPicker numberPickerBillsQty50;
	NumberPicker numberPickerBillsQty20;
	NumberPicker numberPickerBillsQty10;
	NumberPicker numberPickerBillsQty5;
	NumberPicker numberPickerBillsQty1;
	NumberPicker numberPickerCoinsQty100;
	NumberPicker numberPickerCoinsQty50;
	NumberPicker numberPickerCoinsQty25;
	NumberPicker numberPickerCoinsQty10;
	NumberPicker numberPickerCoinsQty5;
	NumberPicker numberPickerCoinsQty1;
	Button buttonCalculate;
	TextView textViewBillTotal;
	TextView textViewCoinTotal;
	TextView textViewBillCoinTotal;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cashcalc);
		
		numberPickerBillsQty100 = (NumberPicker) findViewById(R.id.numberPickerBillsQty100);
		numberPickerBillsQty50 = (NumberPicker) findViewById(R.id.numberPickerBillsQty50);
		numberPickerBillsQty20 = (NumberPicker) findViewById(R.id.numberPickerBillsQty20);
		numberPickerBillsQty10 = (NumberPicker) findViewById(R.id.numberPickerBillsQty10);
		numberPickerBillsQty5 = (NumberPicker) findViewById(R.id.numberPickerBillsQty5);
		numberPickerBillsQty1 = (NumberPicker) findViewById(R.id.numberPickerBillsQty1);
		numberPickerCoinsQty100 = (NumberPicker) findViewById(R.id.numberPickerCoinsQty100);
		numberPickerCoinsQty50 = (NumberPicker) findViewById(R.id.numberPickerCoinsQty50);
		numberPickerCoinsQty25 = (NumberPicker) findViewById(R.id.numberPickerCoinsQty25);
		numberPickerCoinsQty10 = (NumberPicker) findViewById(R.id.numberPickerCoinsQty10);
		numberPickerCoinsQty5 = (NumberPicker) findViewById(R.id.numberPickerCoinsQty5);
		numberPickerCoinsQty1 = (NumberPicker) findViewById(R.id.numberPickerCoinsQty1);
		buttonCalculate = (Button) findViewById(R.id.buttonCalculate);
		textViewBillTotal = (TextView) findViewById(R.id.textViewBillTotal);
		textViewCoinTotal = (TextView) findViewById(R.id.textViewCoinTotal);
		textViewBillCoinTotal = (TextView) findViewById(R.id.textViewBillCoinTotal);
		
		buttonCalculate.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		//Log.d("CashCalcActivity", "onClick'd with value: " + numberPickerBillsQty100.mCurrent);
		float billTotal = numberPickerBillsQty100.mCurrent * 100 +
						  numberPickerBillsQty50.mCurrent  *  50 +
						  numberPickerBillsQty20.mCurrent  *  20 +
						  numberPickerBillsQty10.mCurrent  *  10 +
						  numberPickerBillsQty5.mCurrent   *   5 +
						  numberPickerBillsQty1.mCurrent   *   1;
		double coinTotal = numberPickerCoinsQty100.mCurrent * 1.00 +
						    numberPickerCoinsQty50.mCurrent * 0.50 +
						    numberPickerCoinsQty25.mCurrent * 0.25 +
						    numberPickerCoinsQty10.mCurrent * 0.10 +
						    numberPickerCoinsQty5.mCurrent  * 0.05 +
						    numberPickerCoinsQty1.mCurrent  * 0.01;
		textViewBillTotal.setText(String.format("%.2f", billTotal));
		textViewCoinTotal.setText(String.format("%.2f", coinTotal));
		textViewBillCoinTotal.setText(String.format("%.2f", billTotal + coinTotal));
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.clear:
			clearAmounts();
			return true;
		case R.id.exit:
			exitApp();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	private void clearAmounts() {
		numberPickerBillsQty100.changeCurrent(0);
		numberPickerBillsQty50.changeCurrent(0);
		numberPickerBillsQty20.changeCurrent(0);
		numberPickerBillsQty10.changeCurrent(0);
		numberPickerBillsQty5.changeCurrent(0);
		numberPickerBillsQty1.changeCurrent(0);
		numberPickerCoinsQty100.changeCurrent(0);
		numberPickerCoinsQty50.changeCurrent(0);
		numberPickerCoinsQty25.changeCurrent(0);
		numberPickerCoinsQty10.changeCurrent(0);
		numberPickerCoinsQty5.changeCurrent(0);
		numberPickerCoinsQty1.changeCurrent(0);
		textViewBillTotal.setText(String.format("%.2f", 0.00));
		textViewCoinTotal.setText(String.format("%.2f", 0.00));
		textViewBillCoinTotal.setText(String.format("%.2f", 0.00));
	}

	private void exitApp() {
		Intent intent = new Intent(Intent.ACTION_MAIN);
		intent.addCategory(Intent.CATEGORY_HOME);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(intent);
	}
}