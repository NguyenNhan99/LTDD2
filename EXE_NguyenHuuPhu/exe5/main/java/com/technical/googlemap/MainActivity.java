package com.technical.googlemap;

import android.Manifest;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableFloat;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;


import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.technical.googlemap.databinding.ActivityMainBinding;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity
        implements OnMapReadyCallback, GoogleMap.OnMapClickListener,
        GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener,
        View.OnClickListener {

    private GoogleMap mGoogleMap;

    private GoogleApiClient mGoogleApiClient;
    private static final String MYTAG = "MYTAG";
    public static final int REQUEST_ID_ACCESS_COURSE_FINE_LOCATION = 100;

    private LatLng mCurrentLocation;

    private LatLng mLatLngSearchPosition;

    private ActivityMainBinding mActivityMainBinding;

    private LinearLayout radius15, radius3, radius5, radius10, radius30, radiusall;

    private ObservableFloat mRadiusSearch;

    private Button map1, map2, map3, map4;

    private EditText mSearch;
    private Object Tag;
    private SearchView searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        mGoogleApiClient = new GoogleApiClient.Builder(this).addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        initViews();

        doiMap();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mGoogleApiClient.connect();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mGoogleApiClient.disconnect();
    }

    private void initViews() {
        mActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        SupportMapFragment mapFragment =
                (SupportMapFragment) fragmentManager.findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);
        radius15 = (LinearLayout) mActivityMainBinding.radiusSearch15km;
        radius3 = (LinearLayout) mActivityMainBinding.radiusSearch3km;
        radius5 = (LinearLayout) mActivityMainBinding.radiusSearch5km;
        radius10 = (LinearLayout) mActivityMainBinding.radiusSearch10km;
        radius30 = (LinearLayout) mActivityMainBinding.radiusSearch30km;
        radiusall = (LinearLayout) mActivityMainBinding.radiusSearchAll;

        radius15.setOnClickListener(this);
        radius3.setOnClickListener(this);
        radius5.setOnClickListener(this);
        radius10.setOnClickListener(this);
        radius30.setOnClickListener(this);
        radiusall.setOnClickListener(this);

        mRadiusSearch = new ObservableFloat(Constant.RADIUS_1_5KM);
        mActivityMainBinding.setRadiusSearch(mRadiusSearch.get());
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        if (ActivityCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            final Location lastLocation =
                    LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
            if (lastLocation == null) {
                return;
            }
            mCurrentLocation = new LatLng(lastLocation.getLatitude(), lastLocation.getLongitude());
            if (mLatLngSearchPosition == null) {
                showCameraToPosition(mCurrentLocation, Constant.LEVEL_ZOOM_DEFAULT);
            }
        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onMapClick(LatLng latLng) {
        mLatLngSearchPosition = latLng;
        showMarkerToGoogleMap(mLatLngSearchPosition);

        if (mRadiusSearch.get() <= Constant.RADIUS_DEFAULT
                || mRadiusSearch.get() >= Constant.RADIUS_ALL) {
            showCameraToPosition(mLatLngSearchPosition, Constant.LEVEL_ZOOM_DEFAULT);
        } else {
            final LatLngBounds circleBounds = new LatLngBounds(
                    locationMinMax(false, mLatLngSearchPosition, mRadiusSearch.get()),
                    locationMinMax(true, mLatLngSearchPosition, mRadiusSearch.get()));
            showCameraToPosition(circleBounds, 200);
        }

        showCircleToGoogleMap(mLatLngSearchPosition, mRadiusSearch.get());
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap = googleMap;
        mGoogleMap.setOnMapClickListener(this);
        mGoogleMap.getUiSettings().setCompassEnabled(true);
        mGoogleMap.getUiSettings().setZoomControlsEnabled(true);
        mGoogleMap.getUiSettings().setZoomGesturesEnabled(true);
        mGoogleMap.getUiSettings().setMyLocationButtonEnabled(false);
        mGoogleMap.setTrafficEnabled(true);
        mGoogleMap.setBuildingsEnabled(true);

        if (ActivityCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_COARSE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mGoogleMap.setMyLocationEnabled(true);
        } else {
            //            Common.checkAndRequestPermissionsGPS(getActivity());
        }

//        LatLng hcm = new LatLng(10.852197, 106.758381);
//
//        googleMap.addMarker(new MarkerOptions().position(hcm).title("Marker in HCM City"));
//        CameraPosition cp = new CameraPosition.Builder().target(hcm).zoom(13).build();
//        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cp));
        searchView = (SearchView) findViewById(R.id.search);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                String location = searchView.getQuery().toString();
                List<Address> addressesList = null;
                if (location != null || !location.equals("")) {
                    Geocoder geocoder = new Geocoder(MainActivity.this);
                    try{
                        addressesList = geocoder.getFromLocationName(location, 1);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Address address = addressesList.get(0);
                    LatLng latLng =  new LatLng(address.getLatitude(),address.getLongitude());
                    mGoogleMap.addMarker(new MarkerOptions().position(latLng).title(location));
                    mGoogleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,15));
                }

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
       }

    @Override
    public void onClick(View v) {
        float radius = Constant.RADIUS_DEFAULT;
        switch (v.getId()) {
            case R.id.radius_search_15km:
                radius = Constant.RADIUS_1_5KM;
                break;
            case R.id.radius_search_3km:
                radius = Constant.RADIUS_3KM;
                break;
            case R.id.radius_search_5km:
                radius = Constant.RADIUS_5KM;
                break;
            case R.id.radius_search_10km:
                radius = Constant.RADIUS_10KM;
                break;
            case R.id.radius_search_30km:
                radius = Constant.RADIUS_30KM;
                break;
            case R.id.radius_search_all:
                radius = Constant.RADIUS_ALL;
                break;
        }
        mRadiusSearch.set(radius);
        mActivityMainBinding.setRadiusSearch(mRadiusSearch.get());

        final LatLngBounds circleBounds;
        if (mLatLngSearchPosition == null) {
            mGoogleMap.clear();
            showCircleToGoogleMap(mCurrentLocation, mRadiusSearch.get());
            circleBounds =
                    new LatLngBounds(locationMinMax(false, mCurrentLocation, mRadiusSearch.get()),
                            locationMinMax(true, mCurrentLocation, mRadiusSearch.get()));
        } else {
            showMarkerToGoogleMap(mLatLngSearchPosition);
            showCircleToGoogleMap(mLatLngSearchPosition, mRadiusSearch.get());
            circleBounds = new LatLngBounds(
                    locationMinMax(false, mLatLngSearchPosition, mRadiusSearch.get()),
                    locationMinMax(true, mLatLngSearchPosition, mRadiusSearch.get()));
        }

        showCameraToPosition(circleBounds, 200);
    }

    public void showCameraToPosition(LatLng position, float zoomLevel) {
        CameraPosition cameraPosition = CameraPosition.builder()
                .target(position)
                .zoom(zoomLevel)
                .bearing(0.0f)
                .tilt(0.0f)
                .build();

        if (mGoogleMap != null) {
            mGoogleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition), null);
        }
    }

    public void showCameraToPosition(LatLngBounds bounds, int padding) {
        if (mGoogleMap != null) {
            mGoogleMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, padding));
        }
    }

    public void showCircleToGoogleMap(LatLng position, float radius) {
        if (position == null) {
            return;
        }
        CircleOptions circleOptions = new CircleOptions();
        circleOptions.center(position);
        //Radius in meters
        circleOptions.radius(radius * 1000);
        circleOptions.fillColor(getResources().getColor(R.color.circle_on_map));
        circleOptions.strokeColor(getResources().getColor(R.color.circle_on_map));
        circleOptions.strokeWidth(0);
        if (mGoogleMap != null) {
            mGoogleMap.addCircle(circleOptions);
        }
    }

    public void showMarkerToGoogleMap(LatLng position) {
        mGoogleMap.clear();
        MarkerOptions markerOptions = new MarkerOptions().position(position);
        markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_location_active));
        mGoogleMap.addMarker(markerOptions);
    }

    private LatLng locationMinMax(boolean positive, LatLng position, float radius) {
        double sign = positive ? 1 : -1;
        double dx = (sign * radius * 1000) / 6378000 * (180 / Math.PI);
        double lat = position.latitude + dx;
        double lon = position.longitude + dx / Math.cos(position.latitude * Math.PI / 180);
        return new LatLng(lat, lon);
    }

    public void doiMap() {

        map1 = (Button)findViewById(R.id.map1);
        map2 = (Button)findViewById(R.id.map2);
        map3 = (Button)findViewById(R.id.map3);
        map4 = (Button)findViewById(R.id.map4);


        map1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mGoogleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            }
        });

        map2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mGoogleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            }
        });

        map3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mGoogleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
            }
        });

        map4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mGoogleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            }
        });

    }


    
//    private void init(){
//        Log.d(Tag, "init: initializing");
//
//        mSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
//                if(actionId == EditorInfo.IME_ACTION_SEARCH
//                        || actionId == EditorInfo.IME_ACTION_DONE
//                        || keyEvent.getAction() == KeyEvent.ACTION_DOWN
//                        || keyEvent.getAction() == KeyEvent.KEYCODE_ENTER){
//
//                    //execute our method for searching
//                    geoLocate();
//                }
//
//                return false;
//            }
//        });
//    }
//
//    private void geoLocate(){
//        Log.d(Tag, "geoLocate: geolocating");
//
//        String searchString = mSearch.getText().toString();
//
//        Geocoder geocoder = new Geocoder(MapActivity.this);
//        List<Address> list = new ArrayList<>();
//        try{
//            list = geocoder.getFromLocationName(searchString, 1);
//        }catch (IOException e){
//            Log.e(Tag, "geoLocate: IOException: " + e.getMessage() );
//        }
//
//        if(list.size() > 0){
//            Address address = list.get(0);
//
//            Log.d(Tag, "geoLocate: found a location: " + address.toString());
//            //Toast.makeText(this, address.toString(), Toast.LENGTH_SHORT).show();
//
//        }
//    }
//




}
