package Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import fragment.BuySellFragment;
import fragment.DeliveryFragment;
import fragment.DesignFragment;
import fragment.DevotionalServiceFragment;
import fragment.EntertainmentFragment;
import fragment.FarmAgriFragment;
import fragment.FinancialServicesFragment;
import fragment.HomeServicesFragment;
import fragment.HotelsFragment;
import fragment.ItFragment;
import fragment.LaundryFragment;
import fragment.LocalServicesFragment;
import fragment.ProfessionalServicesFragment;
import fragment.RentalFragment;
import fragment.RepairFragment;
import fragment.BeautyFragment;
import fragment.ElectricianFragment;
import fragment.HealthFragment;
import fragment.CleaningFragment;
import fragment.PackShiftFragment;
import fragment.PaintingFragment;
import fragment.PestControlFragment;
import fragment.PlumberFragment;
import fragment.RestaurantFragment;
import fragment.ShoppingFragment;
import fragment.TrainingFragment;
import fragment.TransportationFragment;
import fragment.TravelFragment;
import fragment.TutorFragment;
import fragment.WeddingEventsFragment;


public class CategoryPagerAdapterAllServices extends FragmentPagerAdapter {

        int mNoOfTabs;

        public CategoryPagerAdapterAllServices(FragmentManager fm, int NumberOfTabs)

        {
                super(fm);
                this.mNoOfTabs = NumberOfTabs;
        }

        @Override
        public Fragment getItem(int position) {
                switch (position) {

                        case 0:
                                BeautyFragment tab1 = new BeautyFragment();
                                return tab1;
                        case 1:
                                RepairFragment tab2 = new RepairFragment();
                                return tab2;
                        case 2:
                                CleaningFragment tab3 = new CleaningFragment();
                                return tab3;

                        case 3:
                                WeddingEventsFragment tab4 = new WeddingEventsFragment();
                                return tab4;

                        case 4:
                                PaintingFragment tab5 = new PaintingFragment();
                                return tab5;

                        case 5:
                                PestControlFragment tab6 = new PestControlFragment();
                                return tab6;

                        case 6:
                                PackShiftFragment tab7 = new PackShiftFragment();
                                return tab7;

                        case 7:
                                PlumberFragment tab8 = new PlumberFragment();
                                return tab8;

                        case 8:
                                BuySellFragment tab9 = new BuySellFragment();
                                return tab9;

                        case 9:
                                DeliveryFragment tab10 = new DeliveryFragment();
                                return tab10;

                        case 10:
                                DesignFragment tab11 = new DesignFragment();
                                return tab11;

                        case 11:
                                DevotionalServiceFragment tab12 = new DevotionalServiceFragment();
                                return tab12;

                        case 12:
                                ElectricianFragment tab13 = new ElectricianFragment();
                                return tab13;

                        case 13:
                                EntertainmentFragment tab14 = new EntertainmentFragment();
                                return tab14;

                        case 14:
                                FarmAgriFragment tab15 = new FarmAgriFragment();
                                return tab15;

                        case 15:
                                FinancialServicesFragment tab16 = new FinancialServicesFragment();
                                return tab16;

                        case 16:
                                HealthFragment tab17 = new HealthFragment();
                                return tab17;

                        case 17:
                                HomeServicesFragment tab18 = new HomeServicesFragment();
                                return tab18;

                        case 18:
                                HotelsFragment tab19 = new HotelsFragment();
                                return tab19;

                        case 19:
                                ItFragment tab20 = new ItFragment();
                                return tab20;

                        case 20:
                                LaundryFragment tab21 = new LaundryFragment();
                                return tab21;

                        case 21:
                                LocalServicesFragment tab22 = new LocalServicesFragment();
                                return tab22;

                        case 22:
                                ProfessionalServicesFragment tab23 = new ProfessionalServicesFragment();
                                return tab23;

                        case 23:
                                RentalFragment tab24 = new RentalFragment();
                                return tab24;

                        case 24:
                                RestaurantFragment tab25 = new RestaurantFragment();
                                return tab25;

                        case 25:
                                ShoppingFragment tab26 = new ShoppingFragment();
                                return tab26;

                        case 26:
                                TrainingFragment tab27 = new TrainingFragment();
                                return tab27;

                        case 27:
                                TransportationFragment tab28 = new TransportationFragment();
                                return tab28;

                        case 28:
                                TravelFragment tab29 = new TravelFragment();
                                return tab29;
                        case 29:
                                TutorFragment tab30 = new TutorFragment();
                                return tab30;

                        default:
                                return null;

                }
        }

        @Override
        public int getCount() {
                return mNoOfTabs;

        }
}

