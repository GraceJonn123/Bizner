package com.jijjy.grace.bizz;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import de.madcyph3r.materialnavigationdrawer.MaterialNavigationDrawer;
import de.madcyph3r.materialnavigationdrawer.activity.MaterialNavHeadItemActivity;
import de.madcyph3r.materialnavigationdrawer.head.MaterialHeadItem;
import de.madcyph3r.materialnavigationdrawer.menu.MaterialMenu;
import de.madcyph3r.materialnavigationdrawer.menu.item.section.MaterialItemSectionFragment;
import de.madcyph3r.materialnavigationdrawer.tools.RoundedCornersDrawable;

public class HeadItem extends MaterialNavHeadItemActivity {

    MaterialNavigationDrawer drawer = null;

    @Override
    protected boolean finishActivityOnNewIntent() {
        return false;
    }

    @Override
    protected int getNewIntentRequestCode(Class clazz) {
        return 0;
    }

    @Override
    public void init(Bundle savedInstanceState) {

        drawer = this;

        // information text for the fragment
        Bundle bundle = new Bundle();
        bundle.putString("Hello", "This should be easy right.");

        Fragment fragmentInstruction = new FragmentInstruction();
        fragmentInstruction.setArguments(bundle);

        // create menu
        MaterialMenu menu = new MaterialMenu();
        menu.add(new MaterialItemSectionFragment(this, "Home", fragmentInstruction, "Head Item Style (One Item)"));
        menu.add(new MaterialItemSectionFragment(this, "About Bizner", new FragmentDummy(), "About Bizner"));
        menu.add(new MaterialItemSectionFragment(this, "Contact Info", new FragmentDummy(), "Contact Info"));
        menu.add(new MaterialItemSectionFragment(this, "What to expect", new FragmentDummy(), "What to expect"));

        // create Head Item
        // use bitmap and make a circle photo
        final Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.logo);
        final RoundedCornersDrawable drawableAppIcon = new RoundedCornersDrawable(getResources(), bitmap);
        MaterialHeadItem headItem = new MaterialHeadItem(this, "My HeadItem", "My Subtitle", drawableAppIcon, R.drawable.commerce, menu);
        this.addHeadItem(headItem);

        // load menu
        this.loadMenu(getCurrentHeadItem().getMenu());

        // load the first MaterialItemSectionFragment from the menu
        this.loadStartFragmentFromMenu(getCurrentHeadItem().getMenu());
    }

    @Override
    public void afterInit(Bundle savedInstanceState) {

    }
}
