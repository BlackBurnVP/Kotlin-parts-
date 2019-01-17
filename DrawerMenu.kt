FILE MAIN ACTIVITY:
---------------------------------------------------------------------------------
  private lateinit var mDrawerLayout: DrawerLayout
  -------------------------------------------------------------------------------
  ON CREATE
  -------------------------------------------------------------------------------
    onCreate{
      mDrawerLayout = findViewById(R.id.drawer_layout)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val actionbar: ActionBar? = supportActionBar
        actionbar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_menu)
        }

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener { menuItem ->
            // set item as selected to persist highlight
            menuItem.isChecked = true
            // close drawer when item is tapped
            mDrawerLayout.closeDrawers()

            // Add code here to update the UI based on the item selected
            // For example, swap UI fragments here

            true
        }(onCreate)
    ------------------------------------------------------------------------------
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                mDrawerLayout.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    
    -------------------------------XML-----------------------------------------
    MAIN ACTIVITY
    ---------------------------------------------------------------------------
    <android.support.v4.widget.DrawerLayout xmlns:android="http://schemas.android.com/apk/res/android"
                                        xmlns:app="http://schemas.android.com/apk/res-auto"
                                        android:id="@+id/drawer_layout"
                                        android:layout_width="match_parent"
                                        android:layout_height="match_parent"
                                        android:fitsSystemWindows="true">
     --------------------------------------------------------------------------
     CONTENT
     --------------------------------------------------------------------------
        <android.support.design.widget.NavigationView
                android:id="@+id/nav_view"
                android:layout_width="wrap_content"
                android:layout_height="match_parent"
                android:layout_gravity="start"
                android:fitsSystemWindows="true"
                app:menu="@menu/drawer_view"/>
    </android.support.v4.widget.DrawerLayout>
    ----------------------------------------------------------------------------
    DRAWER_VIEW.XML
    ----------------------------------------------------------------------------
    <?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <group android:checkableBehavior="single">
        <item
                android:id="@+id/nav_about"
                android:title="@string/about"/>
        <item
                android:id="@+id/nav_credentials"
                android:title="@string/credentials"/>
    </group>
</menu>
