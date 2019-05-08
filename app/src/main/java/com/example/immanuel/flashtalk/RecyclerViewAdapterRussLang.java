package com.example.immanuel.flashtalk;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Immanuel on 2/8/19.
 */


public class RecyclerViewAdapterRussLang extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> categories;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    private static final int TYPE_VOCAB = 2;
    private static final int TYPE_DIALOG = 3;

    // data is passed into the constructor
    RecyclerViewAdapterRussLang(Context context, List<String> data) {
        this.mInflater = LayoutInflater.from(context);
        this.categories = data;

    }

    // inflates the row layout from xml when needed
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView;
        if(viewType==TYPE_HEADER){
            layoutView = mInflater.inflate(R.layout.recycler_view_header_layout, parent, false);
            return new HeaderViewHolder(layoutView);
        }
        else if(viewType==TYPE_ITEM){
            layoutView = mInflater.inflate(R.layout.recycler_view_layout, parent, false);
            return new ItemViewHolder(layoutView);
        }
        else if(viewType==TYPE_VOCAB){
            layoutView = mInflater.inflate(R.layout.recycler_view_vocab_layout, parent, false);
            return new VocabViewHolder(layoutView);
        }
        else{ //TYPE_DIALOG
            layoutView=mInflater.inflate(R.layout.recycler_view_dialog_language_activity_layout,parent,false);
            return new DialogViewHolder(layoutView);
        }
        //TextView textView=view.findViewById(R.id.recycler_view_text_view);
        /*String str=textView.getText().toString();
        if(str.equals("Verbs")){
            textView.setTextSize(30);
        }*/
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        final String subject = categories.get(position);
        if(holder instanceof HeaderViewHolder){
            SpannableString spannableString = new SpannableString(subject);
            //spannableString.setSpan(new UnderlineSpan(),0,subject.length(),0);
            //spannableString.setSpan(new UnderlineSpan(), 0, subject.length(), 0);
            ((HeaderViewHolder)holder).header_textview.setText(spannableString);
            ((HeaderViewHolder)holder).header_textview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos=holder.getAdapterPosition();
                    switch (subject){
                        case "~ Beginner ~":
                            if(categories.get(pos+1).equals("~ Intermediate ~")==false) {
                                int count = 0;
                                while (categories.get(pos + 1).equals("~ Intermediate ~") == false) {
                                    //holder.myTextView.setTextColor(view.getResources().getColor(R.color.black));
                                    categories.remove(pos + 1);
                                    count++;
                                    //categories.remove(pos+1);
                                    //categories.remove(pos+1);
                                }
                                notifyItemRangeRemoved(pos+1, count);
                            }
                            else{
                                categories.add(pos+1,"Alphabet");
                                categories.add(pos+2,"Accents");
                                categories.add(pos+3,"- Essentials 1 -");
                                categories.add(pos+4,"Something Nice!");
                                categories.add(pos+5,"Dialogue 1 - A Testy Exchange");
                                categories.add(pos+6,"- Essentials 2 -");
                                categories.add(pos+7,"Be Polite!");
                                categories.add(pos+8,"Vocab 1 - People");
                                categories.add(pos+9,"I Don't Understand");
                                categories.add(pos+10,"I'm Studying");
                                categories.add(pos+11,"Nouns");
                                categories.add(pos+12,"His House, Her Car");
                                categories.add(pos+13,"Dialogue 2 - A Naive Tourist");
                                categories.add(pos+14,"Vocab 2 - General");
                                categories.add(pos+15,"How's The Weather?");
                                categories.add(pos+16,"A Pretty Woman");
                                categories.add(pos+17,"An Important Exception");
                                categories.add(pos+18,"Countries And People");
                                categories.add(pos+19,"Dialogue 3 - The United Nations");
                                categories.add(pos+20,"This Man, This Woman");
                                categories.add(pos+21,"What?");
                                //categories.add(pos+10,"Vocab 2 - Things");
                                categories.add(pos+22,"I Want");
                                categories.add(pos+23,"I Like");
                                categories.add(pos+24,"Dialogue 4 - A Charming Accent");
                                notifyItemRangeInserted(pos+1, 24);
                            }
                            return;

                        case "~ Intermediate ~":
                            if(categories.get(pos+1).equals("~ Functional ~")==false) {
                                int count = 0;
                                while (categories.get(pos + 1).equals("~ Functional ~") == false) {
                                    //holder.myTextView.setTextColor(view.getResources().getColor(R.color.black));
                                    categories.remove(pos + 1);
                                    count++;
                                    //categories.remove(pos+1);
                                    //categories.remove(pos+1);
                                }
                                notifyItemRangeRemoved(pos+1, count);
                            }
                            else{
                                categories.add(pos+1,"Plurals");
                                categories.add(pos+2,"Exceptions");
                                categories.add(pos+3,"Vocab 3 - Places");
                                categories.add(pos+4,"Dialogue 5 - A Rebel");
                                categories.add(pos+5,"My Friends");
                                categories.add(pos+6,"Interesting People");
                                categories.add(pos+7,"These People");
                                categories.add(pos+8,"I Know Him");
                                categories.add(pos+9,"I Want To Do");
                                categories.add(pos+10,"Vocab 4 - Food/Beverages");
                                categories.add(pos+11,"To Eat");
                                categories.add(pos+12,"To Drink");
                                categories.add(pos+13,"Dialogue 6 - An Impatient Waitress");
                                categories.add(pos+14,"I'm Watching A Movie");
                                categories.add(pos+15,"- To Go -");
                                categories.add(pos+16,"I Can");
                                categories.add(pos+17,"- To Go And Come Back -");
                                categories.add(pos+18,"The One");
                                categories.add(pos+19,"Vocab 5 - Numbers");
                                categories.add(pos+20,"Dialogue 7 - Stereotypes");
                                categories.add(pos+21,"Reading My Book");
                                categories.add(pos+22,"Reading His Book");
                                categories.add(pos+23,"Reading A Good Book");
                                categories.add(pos+24,"I Have");
                                categories.add(pos+25,"In The Store");
                                categories.add(pos+26,"I Live In America");
                                categories.add(pos+27,"Vocab 6 - Time");
                                categories.add(pos+28,"Dialogue 8 - An Ordinary Conversation");
                                categories.add(pos+29,"A Friend's House 1.0");
                                categories.add(pos+30,"A Friend's House 2.0");
                                categories.add(pos+31,"My Friend's House");
                                categories.add(pos+32,"A Pretty Lady's House");
                                categories.add(pos+33,"Dialogue 9 - A Very Boring Man");
                                notifyItemRangeInserted(pos+1, 33);
                            }
                            return;

                        case "~ Functional ~":
                            if(categories.get(pos+1).equals("~ Extras ~")==false) {
                                int count = 0;
                                while (categories.get(pos + 1).equals("~ Extras ~") == false) {
                                    //holder.myTextView.setTextColor(view.getResources().getColor(R.color.black));
                                    categories.remove(pos + 1);
                                    count++;
                                    //categories.remove(pos+1);
                                    //categories.remove(pos+1);
                                }
                                notifyItemRangeRemoved(pos+1, count);
                            }
                            else{
                                categories.add(pos+1,"Where Are You From?");
                                categories.add(pos+2,"For Me, For You");
                                categories.add(pos+3,"For A Friend");
                                categories.add(pos+4,"For My Country");
                                categories.add(pos+5,"I Don't See My Friend");
                                categories.add(pos+6,"What Are You Talking About?");
                                categories.add(pos+7,"You're Talking About My Friend");
                                categories.add(pos+8,"In A Nice Restaurant");
                                categories.add(pos+9,"- The Past -");
                                categories.add(pos+10,"A Few More");
                                categories.add(pos+11,"I Was In The Restaurant");
                                categories.add(pos+12,"The Future");
                                categories.add(pos+13,"- Not So Perfect -");
                                categories.add(pos+14,"He Told Me");
                                /*categories.add(pos+2,"Exceptions");
                                categories.add(pos+3,"My Friends");
                                categories.add(pos+4,"Interesting People");
                                categories.add(pos+5,"These People");
                                categories.add(pos+6,"I Know Him");
                                categories.add(pos+7,"I Want To Do");
                                categories.add(pos+8,"I'm Watching A Movie");
                                categories.add(pos+9,"Vocab 3 - Places");
                                categories.add(pos+10,"- To Go -");
                                categories.add(pos+11,"I Can");
                                categories.add(pos+12,"I'm Reading My Book");
                                categories.add(pos+13,"I'm Reading A Good Book");
                                categories.add(pos+14,"Vocab 4 - Abstract");
                                categories.add(pos+15,"I Have");
                                categories.add(pos+16,"In The Store");
                                categories.add(pos+17,"A Friend's House 1.0");
                                categories.add(pos+18,"A Friend's House 2.0");
                                categories.add(pos+19,"My Friend's House");
                                categories.add(pos+20,"A Pretty Lady's House");*/
                                notifyItemRangeInserted(pos+1, 14);
                            }
                            return;
                    }
                }
            });

        }
        else if(holder instanceof ItemViewHolder){
            ((ItemViewHolder)holder).myTextView.setText(subject);
            ((ItemViewHolder)holder).llayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos=holder.getAdapterPosition();

                    //Toast.makeText(view.getContext(),str+" "+subject, Toast.LENGTH_LONG).show();
                    switch (subject) {
                        case "Alphabet":
                            view.getContext().startActivity(new Intent(view.getContext(), RussianAlphabetActivity.class));
                            return;
                        case "Accents":
                            view.getContext().startActivity(new Intent(view.getContext(), RussianAccentsActivity.class));
                            return;
                        case "- Essentials 1 -":
                            if (categories.get(pos+1).equals("I, You, He, She")) {
                                //holder.myTextView.setTextColor(view.getResources().getColor(R.color.black));
                                categories.remove(pos+1);
                                categories.remove(pos+1);
                                categories.remove(pos+1);
                                notifyItemRangeRemoved(pos+1, 3);
                            } else {
                                //holder.myTextView.setBackgroundResource(R.drawable.rect);
                                //txtView.setBackgroundResource(R.drawable.rect);
                                //holder.myTextView.setTextColor(view.getResources().getColor(R.color.sea_green));
                                categories.add(pos+1, "I, You, He, She");
                                categories.add(pos+2, "Who, What, How");
                                categories.add(pos+3, "Basic Verbs");
                                notifyItemRangeInserted(pos+1,3);
                            /*for(int i=0;i<categories.size();i++){
                                Toast.makeText(view.getContext(),categories.get(i),Toast.LENGTH_SHORT).show();
                            }*/
                            }
                            //Toast.makeText(view.getContext(),categories.get(3)+" "+categories.get(4)+" "+categories.get(5),Toast.LENGTH_SHORT).show();
                            return;

                        case "I, You, He, She":
                            view.getContext().startActivity(new Intent(view.getContext(),RussianBasicPronounsActivity.class));
                            return;

                        case "Who, What, How":
                            view.getContext().startActivity(new Intent(view.getContext(), RussianQuestionWordsActivity.class));
                            return;
                        case "Basic Verbs":
                            view.getContext().startActivity(new Intent(view.getContext(), RussianBasicVerbsActivity.class));
                            return;
                        case "Something Nice!":
                            view.getContext().startActivity(new Intent(view.getContext(),RussianSomethingNiceActivity.class));
                            return;

                        case "- Essentials 2 -":
                            if (categories.get(pos+1).equals("We, They")) {
                                //holder.myTextView.setTextColor(view.getResources().getColor(R.color.black));
                                categories.remove(pos+1);
                                categories.remove(pos+1);
                                //categories.remove(2);
                                notifyItemRangeRemoved(pos+1, 2);
                            } else {
                                //holder.myTextView.setBackgroundResource(R.drawable.rect);
                                //txtView.setBackgroundResource(R.drawable.rect);
                                //holder.myTextView.setTextColor(view.getResources().getColor(R.color.sea_green));
                                categories.add(pos+1, "We, They");
                                categories.add(pos+2, "Wrap Up");
                                //categories.add(4, "Basic Verbs");
                                notifyItemInserted(pos+1);
                                notifyItemInserted(pos+2);
                                //notifyItemInserted(4);
                            }
                            return;

                        case "We, They":
                            //Toast.makeText(view.getContext(),"Hello",Toast.LENGTH_SHORT).show();
                            view.getContext().startActivity(new Intent(view.getContext(),RussianPluralPronounsActivity.class));
                            return;

                        case "Wrap Up":
                            view.getContext().startActivity(new Intent(view.getContext(),RussianCleanupActivity.class));
                            return;

                        case "Be Polite!":
                            view.getContext().startActivity(new Intent(view.getContext(), RussianBePoliteActivity.class));
                            return;

                        case "I Don't Understand":
                            view.getContext().startActivity(new Intent(view.getContext(),RussianIDontUnderstandActivity.class));
                            return;

                        case "I'm Studying":
                            view.getContext().startActivity(new Intent(view.getContext(),RussianImStudyingActivity.class));
                            return;

                        case "Nouns":
                            view.getContext().startActivity(new Intent(view.getContext(),RussianGenderActivity.class));
                            //Toast.makeText(view.getContext(),categories.get(3)+" "+categories.get(4)+" "+categories.get(5), Toast.LENGTH_SHORT).show();
                            return;
                        case "His House, Her Car":
                            view.getContext().startActivity(new Intent(view.getContext(),RussianHisHouseHerCarActivity.class));
                            //Toast.makeText(view.getContext(),categories.get(3)+" "+categories.get(4)+" "+categories.get(5), Toast.LENGTH_SHORT).show();
                            return;
                        case "How's The Weather?":
                            view.getContext().startActivity(new Intent(view.getContext(),RussianHowsTheWeatherActivity.class));
                            //Toast.makeText(view.getContext(),categories.get(3)+" "+categories.get(4)+" "+categories.get(5), Toast.LENGTH_SHORT).show();
                            return;
                        case "An Important Exception":
                            view.getContext().startActivity(new Intent(view.getContext(),RussianAdjectiveExceptionActivity.class));
                            //Toast.makeText(view.getContext(),categories.get(3)+" "+categories.get(4)+" "+categories.get(5), Toast.LENGTH_SHORT).show();
                            return;
                        case "A Pretty Woman":
                            view.getContext().startActivity(new Intent(view.getContext(),RussianAPrettyWomanActivity.class));
                            //Toast.makeText(view.getContext(),categories.get(3)+" "+categories.get(4)+" "+categories.get(5), Toast.LENGTH_SHORT).show();
                            return;
                        case "Countries And People":
                            view.getContext().startActivity(new Intent(view.getContext(),RussianCountriesAndPeopleActivity.class));
                            //Toast.makeText(view.getContext(),categories.get(3)+" "+categories.get(4)+" "+categories.get(5), Toast.LENGTH_SHORT).show();
                            return;

                        case "This Man, This Woman":
                            view.getContext().startActivity(new Intent(view.getContext(),RussianThisManThisWomanActivity.class));
                            //Toast.makeText(view.getContext(),categories.get(3)+" "+categories.get(4)+" "+categories.get(5), Toast.LENGTH_SHORT).show();
                            return;
                        case "What?":
                            view.getContext().startActivity(new Intent(view.getContext(),RussianWhatManWhatWomanActivity.class));
                            //Toast.makeText(view.getContext(),categories.get(3)+" "+categories.get(4)+" "+categories.get(5), Toast.LENGTH_SHORT).show();
                            return;

                        case "I Want":
                            view.getContext().startActivity(new Intent(view.getContext(),RussianIWantActivity.class));
                            //Toast.makeText(view.getContext(),categories.get(3)+" "+categories.get(4)+" "+categories.get(5), Toast.LENGTH_SHORT).show();
                            return;

                        case "I Like":
                            view.getContext().startActivity(new Intent(view.getContext(),RussianToLikeActivity.class));
                            //Toast.makeText(view.getContext(),categories.get(3)+" "+categories.get(4)+" "+categories.get(5), Toast.LENGTH_SHORT).show();
                            return;
                        case "Plurals":
                            view.getContext().startActivity(new Intent(view.getContext(),RussianPluralsActivity.class));
                            //Toast.makeText(view.getContext(),categories.get(3)+" "+categories.get(4)+" "+categories.get(5), Toast.LENGTH_SHORT).show();
                            return;

                        case "Exceptions":
                            view.getContext().startActivity(new Intent(view.getContext(),RussianPluralExceptionsActivity.class));
                            //Toast.makeText(view.getContext(),categories.get(3)+" "+categories.get(4)+" "+categories.get(5), Toast.LENGTH_SHORT).show();
                            return;
                        case "My Friends":
                            view.getContext().startActivity(new Intent(view.getContext(),RussianPluralPossessivePronounsActivity.class));
                            //Toast.makeText(view.getContext(),categories.get(3)+" "+categories.get(4)+" "+categories.get(5), Toast.LENGTH_SHORT).show();
                            return;

                        case "Interesting People":
                            view.getContext().startActivity(new Intent(view.getContext(),RussianPluralAdjectivesActivity.class));
                            //Toast.makeText(view.getContext(),categories.get(3)+" "+categories.get(4)+" "+categories.get(5), Toast.LENGTH_SHORT).show();
                            return;
                        case "These People":
                            view.getContext().startActivity(new Intent(view.getContext(),RussianThesePeopleActivity.class));
                            //Toast.makeText(view.getContext(),categories.get(3)+" "+categories.get(4)+" "+categories.get(5), Toast.LENGTH_SHORT).show();
                            return;

                        case "I Know Him":
                            view.getContext().startActivity(new Intent(view.getContext(),RussianAccusativeCaseActivity.class));
                            //Toast.makeText(view.getContext(),categories.get(3)+" "+categories.get(4)+" "+categories.get(5), Toast.LENGTH_SHORT).show();
                            return;
                        case "I Want To Do":
                            view.getContext().startActivity(new Intent(view.getContext(),RussianIWantToDoActivity.class));
                            //Toast.makeText(view.getContext(),categories.get(3)+" "+categories.get(4)+" "+categories.get(5), Toast.LENGTH_SHORT).show();
                            return;
                        case "To Eat":
                            view.getContext().startActivity(new Intent(view.getContext(),RussianToEatActivity.class));
                            //Toast.makeText(view.getContext(),categories.get(3)+" "+categories.get(4)+" "+categories.get(5), Toast.LENGTH_SHORT).show();
                            return;
                        case "To Drink":
                            view.getContext().startActivity(new Intent(view.getContext(),RussianToDrinkActivity.class));
                            //Toast.makeText(view.getContext(),categories.get(3)+" "+categories.get(4)+" "+categories.get(5), Toast.LENGTH_SHORT).show();
                            return;
                        case "I'm Watching A Movie":
                            view.getContext().startActivity(new Intent(view.getContext(),RussianImWatchingTVActivity.class));
                            //Toast.makeText(view.getContext(),categories.get(3)+" "+categories.get(4)+" "+categories.get(5), Toast.LENGTH_SHORT).show();
                            return;

                        case "- To Go -":
                            if (categories.get(pos+1).equals("To Go On Foot")) {
                                //holder.myTextView.setTextColor(view.getResources().getColor(R.color.black));
                                categories.remove(pos+1);
                                categories.remove(pos+1);
                                categories.remove(pos+1);
                                //categories.remove(2);
                                notifyItemRangeRemoved(pos+1, 3);
                            } else {
                                //holder.myTextView.setBackgroundResource(R.drawable.rect);
                                //txtView.setBackgroundResource(R.drawable.rect);
                                //holder.myTextView.setTextColor(view.getResources().getColor(R.color.sea_green));
                                categories.add(pos+1, "To Go On Foot");
                                categories.add(pos+2, "Where Are You Going?");
                                categories.add(pos+3, "To Go By Vehicle");
                                //categories.add(4, "Basic Verbs");
                                notifyItemInserted(pos+1);
                                notifyItemInserted(pos+2);
                                notifyItemInserted(pos+3);
                                //notifyItemInserted(4);
                            }
                            return;

                        case "To Go On Foot":
                            view.getContext().startActivity(new Intent(view.getContext(),RussianToGoOnFootActivity.class));
                            //Toast.makeText(view.getContext(),categories.get(3)+" "+categories.get(4)+" "+categories.get(5), Toast.LENGTH_SHORT).show();
                            return;
                        case "Where Are You Going?":
                            view.getContext().startActivity(new Intent(view.getContext(),RussianWhereAreYouGoingActivity.class));
                            //Toast.makeText(view.getContext(),categories.get(3)+" "+categories.get(4)+" "+categories.get(5), Toast.LENGTH_SHORT).show();
                            return;
                        case "To Go By Vehicle":
                            view.getContext().startActivity(new Intent(view.getContext(),RussianToGoByVehicleActivity.class));
                            //Toast.makeText(view.getContext(),categories.get(3)+" "+categories.get(4)+" "+categories.get(5), Toast.LENGTH_SHORT).show();
                            return;

                        case "I Can":
                            view.getContext().startActivity(new Intent(view.getContext(),RussianICanActivity.class));
                            //Toast.makeText(view.getContext(),categories.get(3)+" "+categories.get(4)+" "+categories.get(5), Toast.LENGTH_SHORT).show();
                            return;

                        case "- To Go And Come Back -":
                            if (categories.get(pos+1).equals("To Go And Come Back (On Foot)")) {
                                //holder.myTextView.setTextColor(view.getResources().getColor(R.color.black));
                                categories.remove(pos+1);
                                //categories.remove(pos+1);
                                categories.remove(pos+1);
                                //categories.remove(2);
                                notifyItemRangeRemoved(pos+1, 2);
                            } else {
                                //holder.myTextView.setBackgroundResource(R.drawable.rect);
                                //txtView.setBackgroundResource(R.drawable.rect);
                                //holder.myTextView.setTextColor(view.getResources().getColor(R.color.sea_green));
                                categories.add(pos+1, "To Go And Come Back (On Foot)");
                                //categories.add(pos+2, "Where Are You Going?");
                                categories.add(pos+2, "To Go And Come Back (By Vehicle)");
                                //categories.add(4, "Basic Verbs");
                                notifyItemInserted(pos+1);
                                notifyItemInserted(pos+2);
                                //notifyItemInserted(pos+3);
                                //notifyItemInserted(4);
                            }
                            return;


                        case "To Go And Come Back (On Foot)":
                            view.getContext().startActivity(new Intent(view.getContext(),RussianToGoAndReturnOnFootActivity.class));
                            //Toast.makeText(view.getContext(),categories.get(3)+" "+categories.get(4)+" "+categories.get(5), Toast.LENGTH_SHORT).show();
                            return;
                        case "To Go And Come Back (By Vehicle)":
                            view.getContext().startActivity(new Intent(view.getContext(),RussianToGoAndReturnByVehicleActivity.class));
                            //Toast.makeText(view.getContext(),categories.get(3)+" "+categories.get(4)+" "+categories.get(5), Toast.LENGTH_SHORT).show();
                            return;

                        case "The One":
                            view.getContext().startActivity(new Intent(view.getContext(),RussianTheOneActivity.class));
                            //Toast.makeText(view.getContext(),categories.get(3)+" "+categories.get(4)+" "+categories.get(5), Toast.LENGTH_SHORT).show();
                            return;
                        case "Reading My Book":
                            view.getContext().startActivity(new Intent(view.getContext(),RussianImReadingMyBookActivity.class));
                            //Toast.makeText(view.getContext(),categories.get(3)+" "+categories.get(4)+" "+categories.get(5), Toast.LENGTH_SHORT).show();
                            return;
                        case "Reading His Book":
                            view.getContext().startActivity(new Intent(view.getContext(),RussianReadingHisBookActivity.class));
                            //Toast.makeText(view.getContext(),categories.get(3)+" "+categories.get(4)+" "+categories.get(5), Toast.LENGTH_SHORT).show();
                            return;
                        case "Reading A Good Book":
                            view.getContext().startActivity(new Intent(view.getContext(),RussianReadingAGoodBookActivity.class));
                            //Toast.makeText(view.getContext(),categories.get(3)+" "+categories.get(4)+" "+categories.get(5), Toast.LENGTH_SHORT).show();
                            return;
                        case "I Have":
                            view.getContext().startActivity(new Intent(view.getContext(),RussianIHaveActivity.class));
                            //Toast.makeText(view.getContext(),categories.get(3)+" "+categories.get(4)+" "+categories.get(5), Toast.LENGTH_SHORT).show();
                            return;
                        case "In The Store":
                            view.getContext().startActivity(new Intent(view.getContext(),RussianInTheStoreActivity.class));
                            //Toast.makeText(view.getContext(),categories.get(3)+" "+categories.get(4)+" "+categories.get(5), Toast.LENGTH_SHORT).show();
                            return;
                        case "I Live In America":
                            view.getContext().startActivity(new Intent(view.getContext(),RussianToLiveActivity.class));
                            //Toast.makeText(view.getContext(),categories.get(3)+" "+categories.get(4)+" "+categories.get(5), Toast.LENGTH_SHORT).show();
                            return;

                        case "A Friend's House 1.0":
                            view.getContext().startActivity(new Intent(view.getContext(),RussianAFriendsHouseActivity.class));
                            //Toast.makeText(view.getContext(),categories.get(3)+" "+categories.get(4)+" "+categories.get(5), Toast.LENGTH_SHORT).show();
                            return;
                        case "A Friend's House 2.0":
                            view.getContext().startActivity(new Intent(view.getContext(),RussianAFriendsHouse2Activity.class));
                            //Toast.makeText(view.getContext(),categories.get(3)+" "+categories.get(4)+" "+categories.get(5), Toast.LENGTH_SHORT).show();
                            return;
                        case "My Friend's House":
                            view.getContext().startActivity(new Intent(view.getContext(),RussianMyFriendsHouseActivity.class));
                            //Toast.makeText(view.getContext(),categories.get(3)+" "+categories.get(4)+" "+categories.get(5), Toast.LENGTH_SHORT).show();
                            return;
                        case "A Pretty Lady's House":
                            view.getContext().startActivity(new Intent(view.getContext(),RussianActualAPrettyLadysHouseActivity.class));
                            //Toast.makeText(view.getContext(),categories.get(3)+" "+categories.get(4)+" "+categories.get(5), Toast.LENGTH_SHORT).show();
                            return;
                        case "Where Are You From?":
                            view.getContext().startActivity(new Intent(view.getContext(),RussianImFromAmericaActivity.class));
                            //Toast.makeText(view.getContext(),categories.get(3)+" "+categories.get(4)+" "+categories.get(5), Toast.LENGTH_SHORT).show();
                            return;
                        case "For Me, For You":
                            view.getContext().startActivity(new Intent(view.getContext(),RussianForMeForYouActivity.class));
                            //Toast.makeText(view.getContext(),categories.get(3)+" "+categories.get(4)+" "+categories.get(5), Toast.LENGTH_SHORT).show();
                            return;
                        case "For A Friend":
                            view.getContext().startActivity(new Intent(view.getContext(),RussianForAFriendActivity.class));
                            //Toast.makeText(view.getContext(),categories.get(3)+" "+categories.get(4)+" "+categories.get(5), Toast.LENGTH_SHORT).show();
                            return;
                        case "For My Country":
                            view.getContext().startActivity(new Intent(view.getContext(),RussianForMyCountryActivity.class));
                            //Toast.makeText(view.getContext(),categories.get(3)+" "+categories.get(4)+" "+categories.get(5), Toast.LENGTH_SHORT).show();
                            return;
                        case "I Don't See My Friend":
                            view.getContext().startActivity(new Intent(view.getContext(),RussianIDontSeeMyFriendActivity.class));
                            //Toast.makeText(view.getContext(),categories.get(3)+" "+categories.get(4)+" "+categories.get(5), Toast.LENGTH_SHORT).show();
                            return;
                        case "What Are You Talking About?":
                            view.getContext().startActivity(new Intent(view.getContext(),RussianWhatAreYouTalkingAboutActivity.class));
                            //Toast.makeText(view.getContext(),categories.get(3)+" "+categories.get(4)+" "+categories.get(5), Toast.LENGTH_SHORT).show();
                            return;
                        case "You're Talking About My Friend":
                            view.getContext().startActivity(new Intent(view.getContext(),RussianYoureTalkingAboutMyFriendActivity.class));
                            //Toast.makeText(view.getContext(),categories.get(3)+" "+categories.get(4)+" "+categories.get(5), Toast.LENGTH_SHORT).show();
                            return;
                        case "In A Nice Restaurant":
                            view.getContext().startActivity(new Intent(view.getContext(),RussianInANiceRestaurantActivity.class));
                            //Toast.makeText(view.getContext(),categories.get(3)+" "+categories.get(4)+" "+categories.get(5), Toast.LENGTH_SHORT).show();
                            return;

                        case "- The Past -":
                            if (categories.get(pos+1).equals("We Talked!")) {
                                //holder.myTextView.setTextColor(view.getResources().getColor(R.color.black));
                                categories.remove(pos+1);
                                categories.remove(pos+1);
                                categories.remove(pos+1);
                                notifyItemRangeRemoved(pos+1, 3);

                            } else {
                                //holder.myTextView.setBackgroundResource(R.drawable.rect);
                                //txtView.setBackgroundResource(R.drawable.rect);
                                //holder.myTextView.setTextColor(view.getResources().getColor(R.color.sea_green));
                                categories.add(pos+1, "We Talked!");
                                categories.add(pos+2, "I Knew It!");
                                categories.add(pos+3, "I Did It!");
                                notifyItemRangeInserted(pos+1,3);
                            /*for(int i=0;i<categories.size();i++){
                                Toast.makeText(view.getContext(),categories.get(i),Toast.LENGTH_SHORT).show();
                            }*/
                            }
                            //Toast.makeText(view.getContext(),categories.get(3)+" "+categories.get(4)+" "+categories.get(5),Toast.LENGTH_SHORT).show();
                            return;

                        case "We Talked!":
                            view.getContext().startActivity(new Intent(view.getContext(),RussianISaidItActivity.class));
                            //Toast.makeText(view.getContext(),categories.get(3)+" "+categories.get(4)+" "+categories.get(5), Toast.LENGTH_SHORT).show();
                            return;
                        case "I Knew It!":
                            view.getContext().startActivity(new Intent(view.getContext(),RussianIKnewItActivity.class));
                            //Toast.makeText(view.getContext(),categories.get(3)+" "+categories.get(4)+" "+categories.get(5), Toast.LENGTH_SHORT).show();
                            return;
                        case "I Did It!":
                            view.getContext().startActivity(new Intent(view.getContext(),RussianIDidItActivity.class));
                            //Toast.makeText(view.getContext(),categories.get(3)+" "+categories.get(4)+" "+categories.get(5), Toast.LENGTH_SHORT).show();
                            return;
                        case "A Few More":
                            view.getContext().startActivity(new Intent(view.getContext(),RussianAFewMoreActivity.class));
                            //Toast.makeText(view.getContext(),categories.get(3)+" "+categories.get(4)+" "+categories.get(5), Toast.LENGTH_SHORT).show();
                            return;
                        case "I Was In The Restaurant":
                            view.getContext().startActivity(new Intent(view.getContext(),RussianIWasActivity.class));
                            //Toast.makeText(view.getContext(),categories.get(3)+" "+categories.get(4)+" "+categories.get(5), Toast.LENGTH_SHORT).show();
                            return;
                        case "The Future":
                            view.getContext().startActivity(new Intent(view.getContext(),RussianTheFutureActivity.class));
                            //Toast.makeText(view.getContext(),categories.get(3)+" "+categories.get(4)+" "+categories.get(5), Toast.LENGTH_SHORT).show();
                            return;

                        case "- Not So Perfect -":
                            if (categories.get(pos+1).equals("Two For One")) {
                                //holder.myTextView.setTextColor(view.getResources().getColor(R.color.black));
                                categories.remove(pos+1);
                                categories.remove(pos+1);
                                categories.remove(pos+1);
                                categories.remove(pos+1);
                                notifyItemRangeRemoved(pos+1, 4);

                            } else {
                                //holder.myTextView.setBackgroundResource(R.drawable.rect);
                                //txtView.setBackgroundResource(R.drawable.rect);
                                //holder.myTextView.setTextColor(view.getResources().getColor(R.color.sea_green));
                                categories.add(pos+1,"Two For One");
                                categories.add(pos+2, "I Said It!");
                                categories.add(pos+3, "He Did It!");
                                categories.add(pos+4, "I Read It!");
                                notifyItemRangeInserted(pos+1,4);
                            /*for(int i=0;i<categories.size();i++){
                                Toast.makeText(view.getContext(),categories.get(i),Toast.LENGTH_SHORT).show();
                            }*/
                            }
                            return;

                        case "Two For One":
                            view.getContext().startActivity(new Intent(view.getContext(),RussianISaidItPerfectiveActivity.class));
                            //Toast.makeText(view.getContext(),categories.get(3)+" "+categories.get(4)+" "+categories.get(5), Toast.LENGTH_SHORT).show();
                            return;
                        case "I Said It!":
                            view.getContext().startActivity(new Intent(view.getContext(),RussianISaidItPerfectiveActualActivity.class));
                            //Toast.makeText(view.getContext(),categories.get(3)+" "+categories.get(4)+" "+categories.get(5), Toast.LENGTH_SHORT).show();
                            return;
                        case "He Did It!":
                            view.getContext().startActivity(new Intent(view.getContext(),RussianIDidItPerfectiveActualActivity.class));
                            //Toast.makeText(view.getContext(),categories.get(3)+" "+categories.get(4)+" "+categories.get(5), Toast.LENGTH_SHORT).show();
                            return;
                        case "I Read It!":
                            view.getContext().startActivity(new Intent(view.getContext(),RussianIReadItPerfectiveActualActivity.class));
                            //Toast.makeText(view.getContext(),categories.get(3)+" "+categories.get(4)+" "+categories.get(5), Toast.LENGTH_SHORT).show();
                            return;
                        case "He Told Me":
                            view.getContext().startActivity(new Intent(view.getContext(),RussianDativeActivity.class));
                            //Toast.makeText(view.getContext(),categories.get(3)+" "+categories.get(4)+" "+categories.get(5), Toast.LENGTH_SHORT).show();
                            return;

                    }

                /*if(subject.equals("Essentials")){
                    holder.llayout.setBackgroundColor(view.getResources().getColor(R.color.yellow));
                }*/
                }
            });
        }
        else if(holder instanceof VocabViewHolder){
            ((VocabViewHolder)holder).vocab_textview.setText(subject);
            ((VocabViewHolder)holder).vocab_llayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch (subject){
                        case "Vocab 1 - People":
                            Intent intent1=new Intent(view.getContext(),RussianVocabSplash.class);
                            intent1.putExtra("PAGE_POSITION",0);
                            intent1.putExtra("VOCAB_TITLE","Vocab 1 - People");
                            intent1.putExtra("IMAGE_SRC","people");
                            view.getContext().startActivity(intent1);
                            return;
                        case "Vocab 2 - General":
                            Intent intent2=new Intent(view.getContext(),RussianVocabSplash.class);
                            intent2.putExtra("PAGE_POSITION",1);
                            intent2.putExtra("VOCAB_TITLE","Vocab 2 - General");
                            intent2.putExtra("IMAGE_SRC","car1");
                            view.getContext().startActivity(intent2);
                            return;
                        case "Vocab 3 - Places":
                            Intent intent3=new Intent(view.getContext(),RussianVocabSplash.class);
                            intent3.putExtra("PAGE_POSITION",2);
                            intent3.putExtra("VOCAB_TITLE","Vocab 3 - Places");
                            intent3.putExtra("IMAGE_SRC","park");
                            view.getContext().startActivity(intent3);
                            return;
                        case "Vocab 4 - Food/Beverages":
                            Intent intent4=new Intent(view.getContext(),RussianVocabSplash.class);
                            intent4.putExtra("PAGE_POSITION",3);
                            intent4.putExtra("VOCAB_TITLE","Vocab 4 - Food/Beverages");
                            intent4.putExtra("IMAGE_SRC","ice_cream1");
                            view.getContext().startActivity(intent4);
                            return;
                        case "Vocab 5 - Numbers":
                            Intent intent5=new Intent(view.getContext(),RussianVocabSplash.class);
                            intent5.putExtra("PAGE_POSITION",4);
                            intent5.putExtra("VOCAB_TITLE","Vocab 5 - Numbers");
                            intent5.putExtra("IMAGE_SRC","snake1");
                            view.getContext().startActivity(intent5);
                            return;
                    }
                }
            });
        }
        else {
            ((DialogViewHolder)holder).dialog_textview.setText(subject);
            ((DialogViewHolder)holder).dialog_llayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch (subject){
                        case "Dialogue 1 - A Testy Exchange":
                            Intent intent1=new Intent(view.getContext(),RussianDialogueSplashActivity.class);
                            intent1.putExtra("DIALOG_TITLE",subject);
                            intent1.putExtra("IMAGE_SRC","bad_grade2");
                            view.getContext().startActivity(intent1);
                            return;
                        case "Dialogue 2 - A Naive Tourist":
                            Intent intent2=new Intent(view.getContext(),RussianDialogueSplashActivity.class);
                            intent2.putExtra("DIALOG_TITLE",subject);
                            intent2.putExtra("IMAGE_SRC","pyramid2");
                            view.getContext().startActivity(intent2);
                            return;
                        case "Dialogue 3 - The United Nations":
                            Intent intent6=new Intent(view.getContext(),RussianDialogueSplashActivity.class);
                            intent6.putExtra("DIALOG_TITLE",subject);
                            intent6.putExtra("IMAGE_SRC","snake1");
                            view.getContext().startActivity(intent6);
                            return;
                        case "Dialogue 4 - A Charming Accent":
                            Intent intent3=new Intent(view.getContext(),RussianDialogueSplashActivity.class);
                            intent3.putExtra("DIALOG_TITLE",subject);
                            intent3.putExtra("IMAGE_SRC","charming1");
                            view.getContext().startActivity(intent3);
                            return;
                        case "Dialogue 5 - A Rebel":
                            Intent intent4=new Intent(view.getContext(),RussianDialogueSplashActivity.class);
                            intent4.putExtra("DIALOG_TITLE",subject);
                            intent4.putExtra("IMAGE_SRC","weight1");
                            view.getContext().startActivity(intent4);
                            return;
                        case "Dialogue 6 - An Impatient Waitress":
                            Intent intent5=new Intent(view.getContext(),RussianDialogueSplashActivity.class);
                            intent5.putExtra("DIALOG_TITLE",subject);
                            intent5.putExtra("IMAGE_SRC","coffee1");
                            view.getContext().startActivity(intent5);
                            return;
                        case "Dialogue 9 - A Very Boring Man":
                            Intent intent8=new Intent(view.getContext(),RussianDialogueSplashActivity.class);
                            intent8.putExtra("DIALOG_TITLE",subject);
                            intent8.putExtra("IMAGE_SRC","lazy1");
                            view.getContext().startActivity(intent8);
                            return;
                    }
                }
            });
        }
        //int pos=holder.getAdapterPosition();
        //holder.myTextView.setText(subject);
        /*if(subject.equals("Vocab 1 - People")){
            holder.myTextView.setTextColor(holder.myTextView.getResources().getColor(R.color.red));
        }
        if(subject.equals("Vocab 2 - Things")){
            holder.myTextView.setTextColor(holder.myTextView.getResources().getColor(R.color.red));
        }*/

    }

    // total number of rows
    @Override
    public int getItemCount() {
        return categories.size();
    }


    // stores and recycles views as they are scrolled off screen
    /*public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTextView;
        LinearLayout llayout;

        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.recycler_view_text_view);
            llayout=itemView.findViewById(R.id.recycler_view_categories_layout);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }*/

    // convenience method for getting data at click position
    String getItem(int id) {
        return categories.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    @Override
    public int getItemViewType(int position) {
        String str=categories.get(position);
        if (str.equals("~ Beginner ~") || str.equals("~ Intermediate ~") || str.equals("~ Functional ~") || str.equals("~ Extras ~")) {
            return TYPE_HEADER;
        }
        else if(str.equals("Vocab 1 - People") || str.equals("Vocab 2 - General") || str.equals("Vocab 3 - Places") || str.equals("Vocab 4 - Food/Beverages") || str.equals("Vocab 5 - Numbers") || str.equals("Vocab 6 - Time")){
            return TYPE_VOCAB;
        }
        else if(str.equals("Dialogue 1 - A Testy Exchange") || str.equals("Dialogue 2 - A Naive Tourist") || str.equals("Dialogue 3 - The United Nations") || str.equals("Dialogue 4 - A Charming Accent") || str.equals("Dialogue 5 - A Rebel") || str.equals("Dialogue 6 - An Impatient Waitress") || str.equals("Dialogue 7 - Stereotypes") || str.equals("Dialogue 8 - An Ordinary Conversation") || str.equals("Dialogue 8 - A Very Boring Man")){
            return TYPE_DIALOG;
        }
        return TYPE_ITEM;

    }

    /*private boolean isPositionHeader(int position) {
        String str=categories.get(position);
        return (str.equals("Beginner") || str.equals("Functional"));
    }*/
}

class HeaderViewHolder extends RecyclerView.ViewHolder {
    TextView header_textview;

    public HeaderViewHolder(View itemView) {
        super(itemView);
        header_textview = itemView.findViewById(R.id.header_text_view);

    }
}

class ItemViewHolder extends RecyclerView.ViewHolder {
    TextView myTextView;
    LinearLayout llayout;

    public ItemViewHolder(View itemView) {
        super(itemView);
        myTextView = itemView.findViewById(R.id.recycler_view_text_view);
        llayout=itemView.findViewById(R.id.recycler_view_categories_layout);
    }
}

class VocabViewHolder extends RecyclerView.ViewHolder {
    TextView vocab_textview;
    LinearLayout vocab_llayout;

    public VocabViewHolder(View itemView) {
        super(itemView);
        vocab_textview = itemView.findViewById(R.id.vocab_text_view);
        vocab_llayout = itemView.findViewById(R.id.recycler_view_vocab_layout);
    }
}

class DialogViewHolder extends RecyclerView.ViewHolder {
    TextView dialog_textview;
    LinearLayout dialog_llayout;

    public DialogViewHolder(View itemView) {
        super(itemView);
        dialog_textview = itemView.findViewById(R.id.dialog_lang_text_view);
        dialog_llayout = itemView.findViewById(R.id.recycler_view_dialog_language_layout);
    }
}