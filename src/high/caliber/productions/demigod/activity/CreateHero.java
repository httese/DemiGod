package high.caliber.productions.demigod.activity;

import high.caliber.productions.demigod.R;
import high.caliber.productions.demigod.database.HeroDB;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class CreateHero extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.create_hero);

		final HeroDB helper = new HeroDB(CreateHero.this);
		final SQLiteDatabase db = helper.getWritableDatabase();

		final EditText editTxtName = (EditText) findViewById(R.id.etCreateHeroName);

		final Spinner listClasses = (Spinner) findViewById(R.id.spinnerCreateHeroClasses);
		ArrayAdapter dataAdapter = new ArrayAdapter(this,
				android.R.layout.simple_spinner_dropdown_item, getResources()
						.getStringArray(R.array.spinnerClasses));
		dataAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		listClasses.setAdapter(dataAdapter);

		Button bSave = (Button) findViewById(R.id.bCreateHeroSave);
		bSave.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {

				String name = editTxtName.getText().toString();

				if (name.isEmpty()) {
					Toast.makeText(CreateHero.this, "Surely you have a name?",
							Toast.LENGTH_SHORT).show();
				} else {
					ContentValues cv = new ContentValues();

					cv.put(HeroDB.COL_ID, "1");
					cv.put(HeroDB.COL_NAME, name);

					if (String.valueOf(listClasses.getSelectedItem()).equals(
							"Warrior")) {

						cv.put(HeroDB.COL_CLASS, "Warrior");
						cv.put(HeroDB.COL_LVL, "1");
						cv.put(HeroDB.COL_EXP, "0");
						cv.put(HeroDB.COL_MAX_EXP, "100");
						cv.put(HeroDB.COL_HEALTH, "20");
						cv.put(HeroDB.COL_MAX_HEALTH, "20");
						cv.put(HeroDB.COL_ENERGY, "8");
						cv.put(HeroDB.COL_MAX_ENERGY, "8");
						cv.put(HeroDB.COL_MANA, "1");
						cv.put(HeroDB.COL_MAX_MANA, "1");
						cv.put(HeroDB.COL_ATTACK, "6");
						cv.put(HeroDB.COL_MAGIC, "3");
						cv.put(HeroDB.COL_PH_DEFENSE, "10");
						cv.put(HeroDB.COL_MG_DEFENSE, "7");
						cv.put(HeroDB.COL_AGILITY, "4");
						cv.put(HeroDB.COL_DEXTERITY, "4");

						db.insert(HeroDB.getTableStats(), null, cv);
						db.close();

					} else if (String.valueOf(listClasses.getSelectedItem())
							.equals("Mage")) {

						cv.put(HeroDB.COL_CLASS, "Mage");
						cv.put(HeroDB.COL_LVL, "1");
						cv.put(HeroDB.COL_EXP, "0");
						cv.put(HeroDB.COL_MAX_EXP, "100");
						cv.put(HeroDB.COL_HEALTH, "12");
						cv.put(HeroDB.COL_MAX_HEALTH, "12");
						cv.put(HeroDB.COL_ENERGY, "1");
						cv.put(HeroDB.COL_MAX_ENERGY, "1");
						cv.put(HeroDB.COL_MANA, "15");
						cv.put(HeroDB.COL_MAX_MANA, "15");
						cv.put(HeroDB.COL_ATTACK, "3");
						cv.put(HeroDB.COL_MAGIC, "10");
						cv.put(HeroDB.COL_PH_DEFENSE, "3");
						cv.put(HeroDB.COL_MG_DEFENSE, "9");
						cv.put(HeroDB.COL_AGILITY, "7");
						cv.put(HeroDB.COL_DEXTERITY, "4");

						db.insert(HeroDB.getTableStats(), null, cv);
						db.close();

					} else if (String.valueOf(listClasses.getSelectedItem())
							.equals("Mercenary")) {

						cv.put(HeroDB.COL_CLASS, "Mercenary");
						cv.put(HeroDB.COL_LVL, "1");
						cv.put(HeroDB.COL_EXP, "0");
						cv.put(HeroDB.COL_MAX_EXP, "100");
						cv.put(HeroDB.COL_HEALTH, "15");
						cv.put(HeroDB.COL_MAX_HEALTH, "15");
						cv.put(HeroDB.COL_ENERGY, "13");
						cv.put(HeroDB.COL_MAX_ENERGY, "13");
						cv.put(HeroDB.COL_MANA, "2");
						cv.put(HeroDB.COL_MAX_MANA, "2");
						cv.put(HeroDB.COL_ATTACK, "8");
						cv.put(HeroDB.COL_MAGIC, "3");
						cv.put(HeroDB.COL_PH_DEFENSE, "6");
						cv.put(HeroDB.COL_MG_DEFENSE, "4");
						cv.put(HeroDB.COL_AGILITY, "6");
						cv.put(HeroDB.COL_DEXTERITY, "9");

						db.insert(HeroDB.getTableStats(), null, cv);
						db.close();

					}

					helper.PopulateInventoryFields();
					helper.close();
					db.close();
					startActivity(new Intent(CreateHero.this,
							Battle_Activity.class));
					finish();

				}
			}
		});

	}
}
