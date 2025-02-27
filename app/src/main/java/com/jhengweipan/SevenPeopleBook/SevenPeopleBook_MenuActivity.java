package com.jhengweipan.SevenPeopleBook;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.adlocus.PushAd;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.internal.Constants;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareDialog;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.share.Sharer;
import com.facebook.share.model.ShareLinkContent;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.igexin.sdk.PushManager;
import com.jhengweipan.Guandisignonehundred.R;
import com.jhengweipan.MyAPI.VersionChecker;
import com.jhengweipan.ga.MyGAManager;

import myAppKey.mykey;
import util.MySharedPrefernces;

public class SevenPeopleBook_MenuActivity extends Activity {
    private InterstitialAd interstitial;
    private ListView mListView;
    CallbackManager callbackManager;
    ShareDialog shareDialog;
    private static final String TAG = "SevenPeopleBook_MenuActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seven_people_book__menu);
        PushManager.getInstance().initialize(this.getApplicationContext());
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        boolean isbuy=MySharedPrefernces.getIsBuyed(SevenPeopleBook_MenuActivity.this);
        if (isbuy) mAdView.setVisibility(View.GONE);

        interstitial = new InterstitialAd(this);
        interstitial.setAdUnitId(mykey.ad);
        interstitial.loadAd(adRequest);
        // Create ad request.
        Intent promotionIntent = new Intent(this, SevenPeopleBook_MenuActivity.class);
        PushAd.enablePush(this, mykey.AdLoucsKey, promotionIntent);
//        PushAd.test(this);
        if (isbuy)PushAd.disablePush(this);
        // Begin loading your interstitial.

        MyGAManager.sendScreenName(SevenPeopleBook_MenuActivity.this, getResources().getString(R.string.ga_homePage));
        initLayout();
        configVersionCheck();
    }


    private void initLayout() {
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);

        callbackManager = CallbackManager.Factory.create();
        shareDialog = new ShareDialog(this);
        shareDialog.registerCallback(callbackManager, new FacebookCallback<Sharer.Result>() {
            @Override
            public void onSuccess(Sharer.Result result) {

            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });
        mListView = (ListView) findViewById(R.id.SevenPeopleBook_MenuActivity_listview);
        String[] PageName = getResources().getStringArray(R.array.sevenpageame);
        ArrayAdapter<String> pageName = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, PageName);
        mListView.setAdapter(pageName);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {


                    case 0:
                        Intent befall = new Intent();
                        befall.setClass(SevenPeopleBook_MenuActivity.this, NewsActivity.class);
                        startActivity(befall);
                        break;


                    case 1:
                        Intent newplayerteach = new Intent();
                        newplayerteach.setClass(SevenPeopleBook_MenuActivity.this, NewsPlayerTeachActivity.class);
                        startActivity(newplayerteach);
                        break;
                    case 2:
                        Intent hitcity = new Intent();
                        hitcity.setClass(SevenPeopleBook_MenuActivity.this, HitCityActivity.class);
                        startActivity(hitcity);

                        break;
                    case 3:
                        Intent Duplicate = new Intent();
                        Duplicate.setClass(SevenPeopleBook_MenuActivity.this, DuplicateActivity.class);
                        startActivity(Duplicate);
                        break;
                    case 4:
                        Intent master = new Intent();
                        master.setClass(SevenPeopleBook_MenuActivity.this, MasterandapprenticeActivity.class);
                        startActivity(master);

                        break;
                    case 5:
                        Intent updata = new Intent();
                        updata.setClass(SevenPeopleBook_MenuActivity.this, UpDateTimeActivity.class);
                        startActivity(updata);
                        break;
                    case 6:
                        Intent copy = new Intent();
                        copy.setClass(SevenPeopleBook_MenuActivity.this, StrengtheningCopyActivity.class);
                        startActivity(copy);

                        break;


                    case 7:
                        Intent suggest = new Intent();
                        suggest.setClass(SevenPeopleBook_MenuActivity.this, SuggestActivity.class);
                        startActivity(suggest);
                        break;
                    case 8:
                        Intent suggest2 = new Intent();
                        suggest2.setClass(SevenPeopleBook_MenuActivity.this, Suggest2Activity.class);
                        startActivity(suggest2);

                        break;
                    case 9:
                        Intent CrystallizationActivity = new Intent();
                        CrystallizationActivity.setClass(SevenPeopleBook_MenuActivity.this, CrystallizationActivity.class);
                        startActivity(CrystallizationActivity);


                        break;
                    case 10:
                        Intent card = new Intent();
                        card.setClass(SevenPeopleBook_MenuActivity.this, CardDivinationActivity.class);
                        startActivity(card);

                        break;

                    case 11:
                        Intent share = new Intent();
                        share.setClass(SevenPeopleBook_MenuActivity.this, ForIdeaAndShareActivity.class);
                        startActivity(share);
                        break;

                    case 12:
                        Intent teacher = new Intent();
                        teacher.setClass(SevenPeopleBook_MenuActivity.this, TeacherActivity.class);
                        startActivity(teacher);

                        break;
                    case 13:
                        Intent i = new Intent();
                        i.setClass(SevenPeopleBook_MenuActivity.this, QaActivity.class);
                        startActivity(i);
                        break;
                    case 14:
                        Intent a = new Intent();
                        a.setClass(SevenPeopleBook_MenuActivity.this, AwakeningEquipmentActivity.class);
                        startActivity(a);
                        break;
                    case 15:
                        Intent AbyssTower = new Intent();
                        AbyssTower.setClass(SevenPeopleBook_MenuActivity.this, AbyssTowerActivity.class);
                        startActivity(AbyssTower);

                        break;
                    case 16:
                        Intent b = new Intent();
                        b.setClass(SevenPeopleBook_MenuActivity.this, PuzzleActivity.class);
                        startActivity(b);
                        break;
                    case 17:
                        Intent mylist = new Intent();
                        mylist.setClass(SevenPeopleBook_MenuActivity.this, MyListViewActivity.class);
                        startActivity(mylist);
                        break;
                    case 18:
                        Intent ans = new Intent();
                        ans.setClass(SevenPeopleBook_MenuActivity.this,AnsActivity.class);
                        startActivity(ans);
                        break;
                    case 19:
                        Intent buy = new Intent();
                        buy.setClass(SevenPeopleBook_MenuActivity.this, InAppBillingActivity.class);
                        startActivity(buy);
                        break;
<<<<<<< HEAD
                    case 18:
=======
                    case 20:
                        //
>>>>>>> origin/jack
                        if (ShareDialog.canShow(ShareLinkContent.class)) {
                            ShareLinkContent linkContent = new ShareLinkContent.Builder()
                                    .setContentTitle("我只推薦好東西！！")
                                    .setContentDescription("這款APP提供即時訊息，還提供攻略 ，更好的是它會提供每日測驗的解答，趕快來下載吧")
                                    .setImageUrl(Uri.parse("https://lh3.googleusercontent.com/TwYKJsHLG6XYjSdc8c60glRBCRjuJguyNtG0Zn8j3WfUtAJTkqRYKzX1fKEMMLm4dx0=w300-rw"))
                                    .setContentUrl(Uri.parse("https://play.google.com/store/apps/details?id=com.jhengweipan.SevenPeopleBook"))
                                    .build();

                            shareDialog.show(linkContent);

                            break;
                        }
                }
            }
        });


    }

    private void configVersionCheck() {

        VersionChecker.checkOnce(this, new VersionChecker.DoneAdapter() {

            @Override
            public void onHasNewVersion() {
                new AlertDialog.Builder(SevenPeopleBook_MenuActivity.this)
                        .setTitle("已有最新版本!")
                        .setMessage("目前有最新版本上架,請盡快更新")
                        .setNegativeButton("確定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                MyGAManager.sendActionName(SevenPeopleBook_MenuActivity.this, "updata", "installation");
                                startActivity(VersionChecker.openMartketIntent());
                                dialog.dismiss();
                            }
                        })
                        .show();
            }


        });

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            boolean isbuy=MySharedPrefernces.getIsBuyed(SevenPeopleBook_MenuActivity.this);
            if(!isbuy) interstitial.show();
            this.finish();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}