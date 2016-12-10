package com.zerju.weather;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.ActionBar;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import com.zerju.weather.model.Hourly;
import com.zerju.weather.model.Vreme;
import com.zerju.weather.model.Weather;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public class Main2Activity extends AppCompatActivity {

    @Bind(R.id.cityText)
    TextView cityText;
    @Bind(R.id.statusText)
    TextView statusText;
    @Bind(R.id.temperatureText)
    TextView temperatureText;
    @Bind(R.id.horizontalScrollView)
    HorizontalScrollView hsw;
    @Bind(R.id.linearHsw)
    LinearLayout linearHsw;
    @Bind(R.id.daysLayout)
    LinearLayout daysLayout;
    String cityname;
    @Bind(R.id.progressBar1)
    ProgressBar spinner;
    View rootView;
    boolean hidden = true;
    @Bind(R.id.currentLayout)
    LinearLayout currentLayout;
    @Bind(R.id.relativeHide)
    RelativeLayout relativeHide;
    @Bind(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeContainer;
    @Bind(R.id.newLocationBtn)
    Button newLocationBtn;
    @Bind(R.id.copyright)
    TextView copyright;




    public interface CityData {
        @GET("weather.ashx?key=ec06deb22584093c8a148ccf77836&format=json&num_of_days=7")
        Call<Vreme> getCity(@Query("q") String city);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        rootView = this.findViewById(android.R.id.content).getRootView();
        ButterKnife.bind(this, rootView);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setVisibility(View.GONE);
        temperatureText.setText("Loading...");
        spinner.isIndeterminate();
        copyright.setVisibility(View.INVISIBLE);
        newLocationBtn.setVisibility(View.INVISIBLE);
        relativeHide.setVisibility(View.INVISIBLE);
        spinner.setVisibility(View.VISIBLE);
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Intent i = new Intent(getApplicationContext(),Main2Activity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(i);
            }
        });
        // Configure the refreshing colors
        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);



    Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.worldweatheronline.com/free/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Realm realm = Realm.getInstance(getApplicationContext());
        realm.beginTransaction();
        RealmQuery<Location> query = realm.where(Location.class);
        query.equalTo("selected", true);
        RealmResults<Location> result1 = query.findAll();
        realm.commitTransaction();
        if (result1.size() == 0) {
            startActivity(new Intent(getApplicationContext(), LocationActivity.class));
        }else {
            Location searchLocation = result1.get(0);
            CityData service = retrofit.create(CityData.class);
            cityname = searchLocation.getCity() + "," + searchLocation.getCountry();
            Call<Vreme> call = service.getCity(searchLocation.getCity() + "," + searchLocation.getCountry());

            call.enqueue(new Callback<Vreme>() {
                @Override
                public void onFailure(Call<Vreme> call, Throwable t) {
                    Log.e("Failure", "On Failure Line 140");
                }

                @Override
                public void onResponse(Call<Vreme> call, Response<Vreme> response) {
                    Vreme vreme = response.body();
                    if (vreme != null) {
                        cityText.setText(cityname);
                        temperatureText.setText(vreme.getData().getCurrentCondition().get(0).getTempC() + "°");
                        statusText.setText(vreme.getData().getCurrentCondition().get(0).getWeatherDesc().get(0).getValue());
                        int i = 0;

                        for (Hourly hourly : vreme.getData().getWeather().get(0).getHourly()) {
                           final View v = LayoutInflater.from(
                                    getApplicationContext()).inflate(
                                    R.layout.daysforecast, (ViewGroup) findViewById(android.R.id.content).getRootView(), false);

                            TextView dateText = (TextView) v.findViewById(R.id.dateText);
                            ImageView forecastImage = (ImageView) v.findViewById(R.id.forecastImage);
                            TextView maxTemp = (TextView) v.findViewById(R.id.maxTempText);

                            SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEEE"); // the day of the week spelled out completely

                            String ura = "";//time is written in a format like 300 for 3:00 so I need to reformat it so it looks better,
                            if(hourly.getTime().equals("0")){// my format doesnt work when the length of the string is less than 2 which only happens at 0
                                ura = "0:00";
                            }else {
                                ura = hourly.getTime().substring(0, hourly.getTime().length() - 2) + ":" + hourly.getTime().substring(hourly.getTime().length() - 2);
                            }

                            dateText.setText(ura);
                            // String status = vreme.getData().getWeather().get(i).getHourly().get(6).getWeatherDesc().get(0).getValue().toString().toUpperCase();


                            Target target = new Target() {
                                @Override
                                public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                                    v.setAlpha((float)0.4);
                                  //  v.setBackgroundColor(bitmap.getPixel(0,0));
                                }

                                @Override
                                public void onBitmapFailed(Drawable errorDrawable) {
                                }

                                @Override
                                public void onPrepareLoad(Drawable placeHolderDrawable) {
                                }
                            };

                            Picasso.with(getApplicationContext()).load(hourly.getWeatherIconUrl().get(0).getValue().toString()).into(target);
                            Picasso.with(getApplicationContext()).load(hourly.getWeatherIconUrl().get(0).getValue().toString()).into(forecastImage);

                            maxTemp.setText(hourly.getTempC() + "°C");
                            linearHsw.addView(v);

                            i++;
                        }
                        int j = 0;
                        for (Weather weather : vreme.getData().getWeather()) {
                            View v2 = LayoutInflater.from(
                                    getApplicationContext()).inflate(
                                    R.layout.daysoftheweek, (ViewGroup) rootView, false);

                            TextView dayText = (TextView) v2.findViewById(R.id.dayText);
                            TextView descText = (TextView) v2.findViewById(R.id.descText);
                            TextView tempText = (TextView) v2.findViewById(R.id.tempText);
                            SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEEE");
                            try {
                                Date predefined = new SimpleDateFormat("yyyy-MM-dd").parse(weather.getDate());
                                dayText.setText(simpleDateformat.format(predefined));
                            } catch (Exception e) {
                                Log.e("Exception date weather", e.getMessage());
                            }
                            if (j > 2) {
                                v2.setVisibility(View.GONE);
                            }
                            descText.setText(weather.getHourly().get(6).getWeatherDesc().get(0).getValue());
                            tempText.setText(weather.getMintempC() + "°|" + weather.getMaxtempC() + "°");
                            v2.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {//da se visina view-ja prilagaja tistemu ko se razsiri
                                @Override
                                public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                                    v.getLayoutParams().height = ViewGroup.LayoutParams.WRAP_CONTENT;
                                }
                            });
                            j++;
                            daysLayout.addView(v2);
                        }

                        daysLayout.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
                        final TextView viewmoredays = (TextView) relativeHide.findViewById(R.id.viewMoreDays);
                        viewmoredays.setText("View more days");
                        final ImageView imageView = (ImageView) relativeHide.findViewById(R.id.arrowDownImage);
                        final int height = daysLayout.getMeasuredHeight();
                        relativeHide.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                int count = daysLayout.getChildCount();
                                if (hidden) {
                                    imageView.setImageResource(R.drawable.arrow_blue_up);
                                    viewmoredays.setText("Hide");
                                    animationAlpha(daysLayout, height, (height / 3) * 5, 30, 30, false, count);

                                    for (int i = 0; i < count; i++) {
                                        daysLayout.getChildAt(i).setVisibility(View.VISIBLE);
                                    }
                                    hidden = false;
                                } else {
                                    imageView.setImageResource(R.drawable.arrow_grey_down);
                                    viewmoredays.setText("Show more days");
                                    animationAlpha(daysLayout, (height / 3) * 5, height, 30, 30, true, count);
                                    hidden = true;
                                }
                            }
                        });

                        inflateCurrent(vreme);


                    } else {
                        temperatureText.setVisibility(View.VISIBLE);
                        temperatureText.setText("No connection");
                    }
                }

            });

            spinner.setVisibility(View.GONE);
            copyright.setVisibility(View.VISIBLE);
            newLocationBtn.setVisibility(View.VISIBLE);
            relativeHide.setVisibility(View.VISIBLE);
        }

    }

    @OnClick({R.id.newLocationBtn})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.newLocationBtn:
                startActivity(new Intent(getApplicationContext(), LocationActivity.class));
                this.finish();
                break;

        }
    }
    private void animationAlpha(final View v, int minHeight, final int maxHeight, int startAlpha, int endAlpha, final boolean shrink,final int count) {
        try {
            ObjectAnimator.ofFloat(v, View.ALPHA, startAlpha, endAlpha)
                    .setDuration(750)
                    .start();

            ValueAnimator va = ValueAnimator.ofInt(minHeight, maxHeight)
                    .setDuration(750);
            va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {

                    v.getLayoutParams().height = (Integer) animation.getAnimatedValue();
                    v.requestLayout();
                }
            });

            va.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {
                }

                @Override
                public void onAnimationEnd(Animator animation) {

                    if (shrink) {//ce hocemo skriti childe
                        for (int i = 3; i < count; i++) {
                            daysLayout.getChildAt(i).setVisibility(View.GONE);
                        }
                    }


                }

                @Override
                public void onAnimationCancel(Animator animation) {
                }

                @Override
                public void onAnimationRepeat(Animator animation) {
                }
            });

            va.start();
        } catch (Exception e) {
            Log.e("Exception anim", e.getMessage());
        }
    }


    public void inflateCurrent(Vreme vreme){
        View currentView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.current_condition,(ViewGroup)rootView,false);
        TextView windText = (TextView)currentView.findViewById(R.id.windText);
        TextView humidityText = (TextView)currentView.findViewById(R.id.humidityText);
        TextView pressureText = (TextView)currentView.findViewById(R.id.pressureText);
        TextView feelsText = (TextView)currentView.findViewById(R.id.feelsText);
        TextView visibilityText = (TextView)currentView.findViewById(R.id.visibilityText);
        TextView precipText = (TextView)currentView.findViewById(R.id.precipText);

        windText.setText(vreme.getData().getCurrentCondition().get(0).getWindspeedKmph()+"km/h");
        humidityText.setText(vreme.getData().getCurrentCondition().get(0).getHumidity()+ "%");
        pressureText.setText(vreme.getData().getCurrentCondition().get(0).getPressure()+" hPa");
        feelsText.setText(vreme.getData().getCurrentCondition().get(0).getFeelsLikeC()+"°C");
        visibilityText.setText(vreme.getData().getCurrentCondition().get(0).getVisibility()+"km");
        precipText.setText(vreme.getData().getCurrentCondition().get(0).getPrecipMM()+"mm");

        currentLayout.addView(currentView);
    }
}
