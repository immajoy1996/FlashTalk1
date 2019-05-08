package com.example.immanuel.flashtalk;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Immanuel on 2/8/19.
 *
 */

interface AdapterCallBack{
    //public void onSomeItemsSelected(int count,Map<String,Boolean>Selected);
    public void onSomeItemsSelected(int count,String return_string);

}

public class RussianGameSelectionRecyclerAdapter extends RecyclerView.Adapter<RussianGameSelectionRecyclerAdapter.ViewHolder> {

    private int TOT_LESSONS=7;
    private List<String> categories;
    private AdapterCallBack adapterCallBack;
    private int count;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    //private Map<String,Boolean> Selected;
    private String return_string;
    //private ArrayList<String>category_names;
    final int color_black;
    final int color_white;

    // data is passed into the constructor
    public RussianGameSelectionRecyclerAdapter(Context context, List<String> data,AdapterCallBack acb) {
        this.mInflater = LayoutInflater.from(context);
        this.categories = data;
        this.count=0;
        this.adapterCallBack=acb;
        //Selected=new HashMap<String,Boolean>();
        ArrayList<String>category_names=new ArrayList<String>();
        color_black=context.getResources().getColor(R.color.black);
        color_white=context.getResources().getColor(R.color.white);
        return_string="0000";

    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recycler_view_header_layout, parent, false);
        //TextView textView=view.findViewById(R.id.header_text_view);
        /*String str=textView.getText().toString();
        if(str.equals("Verbs")){
            textView.setTextSize(30);
        }*/
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final String subject = categories.get(position);
        holder.myTextView.setText(subject);

        /*if(subject.equals("- Essentials 1 -") || subject.equals("- Essentials 2 -")){
            holder.myCheckBox.setVisibility(View.INVISIBLE);
        }

        if(subject.equals("Vocab 1 - People")){
            holder.myTextView.setTextColor(holder.myTextView.getResources().getColor(R.color.red));
        }*/

        /*if(select_all==true){
            holder.myCheckBox.setChecked(true);
        }*/

        holder.myTextView.setOnClickListener(new View.OnClickListener() {
            String title = holder.myTextView.getText().toString();

            @Override
            public void onClick(View view) {
                int pos=holder.getAdapterPosition();
                if (holder.myTextView.getCurrentTextColor() == color_black) {
                    holder.myTextView.setTextColor(color_white);
                    holder.myTextView.setBackgroundResource(R.drawable.game_selector1);
                    //Selected.put(title, true);
                    return_string=return_string.substring(0,pos)+"1"+return_string.substring(pos+1);
                    count++;
                } else {
                    holder.myTextView.setTextColor(color_black);
                    holder.myTextView.setBackgroundResource(R.drawable.game_selector2);
                    count--;
                    return_string=return_string.substring(0,pos)+"0"+return_string.substring(pos+1);
                    //Selected.put(title, false);
                }
                //Toast.makeText(view.getContext(),return_string,Toast.LENGTH_SHORT).show();
                adapterCallBack.onSomeItemsSelected(count, return_string);
            }
        });


        /*holder.llayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int pos=holder.getAdapterPosition();


                /*int text_color_black=view.getResources().getColor(R.color.black);
                int text_color_red=view.getResources().getColor(R.color.red);

                if(subject.equals("- Essentials 1 -")==false && subject.equals("- Essentials 2 -")==false) {

                    int cur_color=holder.myTextView.getCurrentTextColor();

                    if(cur_color==text_color_black || cur_color==text_color_red){
                        holder.myTextView.setBackgroundResource(R.drawable.game_selector1);
                        //holder.myTextView.setBackgroundColor(view.getResources().getColor(R.color.medium_sea_green));
                        holder.myTextView.setTextColor(view.getResources().getColor(R.color.white));

                    }
                    else{
                        holder.myTextView.setBackgroundResource(R.drawable.game_selector2);
                        //holder.myTextView.setBackgroundColor(view.getResources().getColor(R.color.white_smoke));
                        if(subject.equals("Vocab 1 - People")) {
                            holder.myTextView.setTextColor(view.getResources().getColor(R.color.red));
                        }
                        else{
                            holder.myTextView.setTextColor(view.getResources().getColor(R.color.black));
                        }
                    }
                }*/

        //Toast.makeText(view.getContext(),str+" "+subject, Toast.LENGTH_LONG).show();
                /*switch (subject) {
                    case "Practice Everything":
                        //view.getContext().startActivity(new Intent(view.getContext(), RussianAlphabetActivity.class));
                        return;
                    case "- Essentials 1 -":
                        String s = categories.get(pos+1);
                        if (s.equals("Basic Pronouns")) {
                            holder.myTextView.setTextColor(view.getResources().getColor(R.color.black));
                            categories.remove(pos+1);
                            categories.remove(pos+1);
                            categories.remove(pos+1);
                            notifyItemRangeRemoved(pos+1, 3);
                        } else {
                            //holder.myTextView.setBackgroundResource(R.drawable.rect);
                            //txtView.setBackgroundResource(R.drawable.rect);
                            holder.myTextView.setTextColor(view.getResources().getColor(R.color.sea_green));
                            categories.add(pos+1, "Basic Pronouns");
                            categories.add(pos+2, "Question Words");
                            categories.add(pos+3, "Basic Verbs");
                            notifyItemRangeInserted(pos+1,3);
                            /*for(int i=0;i<categories.size();i++){
                                Toast.makeText(view.getContext(),categories.get(i),Toast.LENGTH_SHORT).show();
                            }*/
        //}
        //Toast.makeText(view.getContext(),categories.get(3)+" "+categories.get(4)+" "+categories.get(5),Toast.LENGTH_SHORT).show();
        //return;

                    /*case "Basic Pronouns":
                        //view.getContext().startActivity(new Intent(view.getContext(),RussianBasicPronounsActivity.class));
                        return;

                    case "Question Words":
                        //view.getContext().startActivity(new Intent(view.getContext(), RussianQuestionWordsActivity.class));
                        return;
                    case "Basic Verbs":
                        //view.getContext().startActivity(new Intent(view.getContext(), RussianBasicVerbsActivity.class));
                        return;

                    case "- Essentials 2 -":
                        String t = categories.get(pos+1);
                        if (t.equals("Plural Pronouns")) {
                            holder.myTextView.setTextColor(view.getResources().getColor(R.color.black));
                            categories.remove(pos+1);
                            categories.remove(pos+1);
                            //categories.remove(2);
                            notifyItemRangeRemoved(pos+1, 2);
                        } else {
                            //holder.myTextView.setBackgroundResource(R.drawable.rect);
                            //txtView.setBackgroundResource(R.drawable.rect);
                            holder.myTextView.setTextColor(view.getResources().getColor(R.color.sea_green));
                            categories.add(pos+1, "Plural Pronouns");
                            categories.add(pos+2, "Cleanup");
                            //categories.add(4, "Basic Verbs");
                            notifyItemInserted(pos+1);
                            notifyItemInserted(pos+2);
                            //notifyItemInserted(4);
                        }
                        return;

                    case "Plural Pronouns":
                        //Toast.makeText(view.getContext(),"Hello",Toast.LENGTH_SHORT).show();
                        //view.getContext().startActivity(new Intent(view.getContext(),RussianPluralPronounsActivity.class));
                        return;

                    case "Cleanup":
                        //view.getContext().startActivity(new Intent(view.getContext(),RussianCleanupActivity.class));
                        return;

                    case "Vocab 1 - People":
                        //view.getContext().startActivity(new Intent(view.getContext(),RussianVocabActivity.class));
                        return;
                }



                /*if(subject.equals("Essentials")){
                    holder.llayout.setBackgroundColor(view.getResources().getColor(R.color.yellow));
                }*/
        //}
        //});
        //}

    }

    // total number of rows
    @Override
    public int getItemCount() {
        return categories.size();
    }

    public boolean isThereSelected(){
        return (count==0)?false:true;
    }

    public void increment(int x){
        count=count+x;
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTextView;
        //CheckBox myCheckBox;
        //LinearLayout llayout;

        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.header_text_view);
            //myCheckBox=itemView.findViewById(R.id.checkbox);
            //llayout=itemView.findViewById(R.id.recycler_view_checkbox_layout);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

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
}