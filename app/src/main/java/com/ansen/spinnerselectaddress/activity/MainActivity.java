package com.ansen.spinnerselectaddress.activity;

import com.ansen.spinnerselectaddress.R;
import com.ansen.spinnerselectaddress.view.SelectPopupWindow;
import com.ansen.spinnerselectaddress.view.SelectPopupWindow.SelectCategory;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * 主Activity
 * @author ansen
 * @create time 2015-09-25
 */
public class MainActivity extends AppCompatActivity implements OnClickListener{
	private SelectPopupWindow mPopupWindow = null;
	
	private TextView tvZuQuyu;
	
	private String[] parentStrings = {"全城","中原区","二七区","管城区","金水区","上街区","惠济区","郑东新区","高新区","经开区","郑州周边"};
	private String[][] childrenStrings={{},
			{"中原1","中原2","中原3","中原4","中原5","中原6","中原7","中原8","中原9","中原10","中原11","中原12","中原13","中原14","中原15"},
			{"二七1","二七2","二七3","二七4","二七5","二七6","二七7","二七8","二七9","二七10","二七11","二七12","二七13","二七14","二七15"},
			{"管城1","管城2","管城3","管城4","管城5","管城6","管城7","管城8","管城9","管城10","管城11","管城12","管城13","管城14","管城15"},
			{"金水1","金水2","金水3","金水4","金水5","金水6","金水7","金水8","金水9","金水10","金水11","金水12","金水13","金水14","金水15"},
			{"上街1","上街2","上街3","上街4","上街5","中原6","中原7","中原8","中原9","中原10","中原11","中原12","中原13","中原14","中原15"},
			{"中原1","中原2","中原3","中原4","中原5","中原6","中原7","中原8","中原9","中原10","中原11","中原12","中原13","中原14","中原15"},
			{"郑东新区1","郑东新区2","郑东新区3","中原4","中原5","中原6","中原7","中原8","中原9","中原10","中原11","中原12","中原13","中原14","中原15"},
			{"高新区1","高新区2","高新区3","中原4","中原5","中原6","中原7","中原8","中原9","中原10","中原11","中原12","中原13","中原14","中原15"},
			{"经开区1","经开区2","经开区3","中原4","中原5","中原6","中原7","中原8","中原9","中原10","中原11","中原12","中原13","中原14","中原15"},
			{"周边1","周边2","周边3","中原4","中原5","中原6","中原7","中原8","中原9","中原10","中原11","中原12","中原13","中原14","中原15"},
	};
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chuzu_city_main);
		
		tvZuQuyu = findViewById(R.id.tvZuQuyu);
		tvZuQuyu.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tvZuQuyu:
			if(mPopupWindow == null){
				mPopupWindow = new SelectPopupWindow(parentStrings,childrenStrings,this,selectCategory);
			}
			mPopupWindow.showAsDropDown(tvZuQuyu, -5, 10);
			break;
		}
	}
	
	/**
	 * 选择完成回调接口
	 */
	private SelectCategory selectCategory=new SelectCategory() {
		@Override
		public void selectCategory(int parentSelectposition,int childrenSelectposition) {
			String parentStr=parentStrings[parentSelectposition];
			String childrenStr=childrenStrings[parentSelectposition][childrenSelectposition];
			
			Toast.makeText(MainActivity.this, "父类别:"+parentStr+"  子类别:"+childrenStr, Toast.LENGTH_SHORT).show();
		}
	};
}
