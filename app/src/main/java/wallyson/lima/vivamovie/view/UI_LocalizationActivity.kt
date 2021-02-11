package wallyson.lima.vivamovie.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import wallyson.lima.vivamovie.R

class UI_LocalizationActivity : AppCompatActivity(), OnMapReadyCallback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_localization)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.mapView) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        var mMap = googleMap

        val vivaDecora = LatLng(-23.5617693,-46.6654908)
        mMap?.addMarker(MarkerOptions().position(vivaDecora).title(getString(R.string.vivadecora)))
        mMap?.moveCamera(CameraUpdateFactory.newLatLng(vivaDecora))
    }
}