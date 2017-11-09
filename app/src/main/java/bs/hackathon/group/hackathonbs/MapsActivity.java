package bs.hackathon.group.hackathonbs;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.Criteria;
import android.location.LocationProvider;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;

import java.util.Arrays;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    LocationManager lM;

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lM = (LocationManager) this.getSystemService(this.LOCATION_SERVICE);

        if (!canAccessLocation()) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},0);
        }

        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_COARSE);
        criteria.setAltitudeRequired(false);
        criteria.setBearingRequired(false);
        criteria.setCostAllowed(true);
        String provider = lM.getBestProvider(criteria, true);

        List<String> providerList = lM.getAllProviders();

        System.out.println(Arrays.toString(providerList.toArray()));

        LocationProvider locProvide = lM.getProvider(LocationManager.GPS_PROVIDER);

        Location currentLoc = new Location("");//provider name is unnecessary
        currentLoc.setLatitude(0.0d);//your coords of course
        currentLoc.setLongitude(0.0d);
        try {
            currentLoc = lM.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);//locProvide.getName());
        } catch (SecurityException se) {
            System.out.println("ERROR");
        }
        // Add a marker in Sydney and move the camera
        LatLng currentLatLng = new LatLng(currentLoc.getLatitude(), currentLoc.getLongitude());
        LatLng helperLatLng = new LatLng(currentLoc.getLatitude() + 0.005, currentLoc.getLongitude()  + 0.005);
        LatLng helperLatLng2 = new LatLng(currentLoc.getLatitude() - 0.005, currentLoc.getLongitude()  - 0.005);

        mMap.addMarker(new MarkerOptions().position(currentLatLng).title("Du bist hier!"));

        MarkerOptions mO1 = new MarkerOptions().position(helperLatLng).title("Gassi mit Puschel");
        MarkerOptions mO2 = new MarkerOptions().position(helperLatLng).title("REWE-Einkauf bei Omi");
        mMap.addMarker(mO1.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mMap.addMarker(mO2.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(currentLatLng));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15));
    }

    private boolean canAccessLocation() {
        return(hasPermission(Manifest.permission.ACCESS_FINE_LOCATION));
    }

    private boolean hasPermission(String perm) {
        return(PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(this, perm));
    }
}

