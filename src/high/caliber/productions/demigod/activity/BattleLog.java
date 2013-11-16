package high.caliber.productions.demigod.activity;

import high.caliber.productions.demigod.R;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class BattleLog extends Activity implements OnClickListener {

	SharedPreferences prefs;

	TextView tvDamageDealt, tvLifeTimeDamageDealt, tvDamageRecieved,
			tvLifeTimeDamageRecieved;

	Button bContinue;

	int damageDealt, lifeTimeDamageDealt, damageRecieved,
			lifeTimeDamageRecieved;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.battle_log);

		prefs = getSharedPreferences("BattleLog", 0);

		damageDealt = prefs.getInt("DamageDealt", 0);
		lifeTimeDamageDealt = prefs.getInt("LifeTimeDamageDealt", 0);
		damageRecieved = prefs.getInt("DamageRecieved", 0);
		lifeTimeDamageRecieved = prefs.getInt("LifeTimeDamageRecieved", 0);

		tvDamageDealt = (TextView) findViewById(R.id.tvBattleLog_DamageDealt);
		tvDamageDealt.setText(String.valueOf(damageDealt));

		tvLifeTimeDamageDealt = (TextView) findViewById(R.id.tvBattleLog_LifeTimeDamageDealt);
		tvLifeTimeDamageDealt.setText(String.valueOf(lifeTimeDamageDealt));

		tvDamageRecieved = (TextView) findViewById(R.id.tvBattleLog_DamageRecieved);
		tvDamageRecieved.setText(String.valueOf(damageRecieved));

		tvLifeTimeDamageRecieved = (TextView) findViewById(R.id.tvBattleLog_LifeTimeDamageRecieved);
		tvLifeTimeDamageRecieved
				.setText(String.valueOf(lifeTimeDamageRecieved));

		bContinue = (Button) findViewById(R.id.bBattleLog_Continue);
		bContinue.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {

		if (v.getId() == R.id.bBattleLog_Continue) {

			Intent intent = new Intent("com.example.rpg.WORLD");
			startActivity(intent);
			finish();

		}

	}

	@Override
	protected void onDestroy() {
		super.onDestroy();

		prefs = getSharedPreferences("BattleLog", 0);

		Editor editor = prefs.edit();
		editor.putInt("DamageDealt", 0);
		editor.putInt("DamageRecieved", 0);
		editor.commit();
	}

}