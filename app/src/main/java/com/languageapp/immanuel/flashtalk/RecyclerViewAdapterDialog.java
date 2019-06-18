package com.languageapp.immanuel.flashtalk;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Immanuel on 2/8/19.
 */


public class RecyclerViewAdapterDialog extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> dialog_images;
    private List<String> dialog_titles;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    //private static final int TYPE_VOCAB = 2;

    // data is passed into the constructor
    RecyclerViewAdapterDialog(Context context, List<String> data1, List<String> data2) {
        this.mInflater = LayoutInflater.from(context);
        this.dialog_images = data1;
        this.dialog_titles = data2;
    }

    // inflates the row layout from xml when needed
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView;
        if(viewType==TYPE_HEADER){
            layoutView = mInflater.inflate(R.layout.russian_dialog_header_layout, parent, false);
            return new HeaderDialogViewHolder(layoutView);
        }
        else{ // TYPE_ITEM
            layoutView = mInflater.inflate(R.layout.recycler_view_dialog_layout, parent, false);
            return new ItemDialogViewHolder(layoutView);
        }
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        final String img = dialog_images.get(position);
        final String title = dialog_titles.get(position);

        if(holder instanceof HeaderDialogViewHolder){
            final TextView textView_header=((HeaderDialogViewHolder) holder).header_textview;
            textView_header.setText(title);
        }

        else{
            final TextView textView_image=((ItemDialogViewHolder) holder).textView_image;
            final TextView textView_title=((ItemDialogViewHolder) holder).textView_title;
            final LinearLayout layout=((ItemDialogViewHolder) holder).layout;

            int id = textView_image.getContext().getResources().getIdentifier(img, "drawable", textView_image.getContext().getPackageName());
            textView_image.setBackgroundResource(id);
            textView_title.setText(title);

            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //textView_title.setBackgroundColor(view.getResources().getColor(R.color.white_smoke));
                    switch (title){
                        case "A Testy Exchange":
                            Intent intent1=new Intent(view.getContext(),RussianDialog1Activity.class);
                            //intent1.putExtra("FROM_PAGE","Main Dialog Page");
                            view.getContext().startActivity(intent1);
                            return;
                        case "A Naive Tourist":
                            Intent intent2=new Intent(view.getContext(),RussianDialog2Activity.class);
                            //intent1.putExtra("FROM_PAGE","Main Dialog Page");
                            view.getContext().startActivity(intent2);
                            return;
                        case "The United Nations":
                            Intent intent3=new Intent(view.getContext(),RussianDialog3Activity.class);
                            //intent1.putExtra("FROM_PAGE","Main Dialog Page");
                            view.getContext().startActivity(intent3);
                            return;
                        case "A Charming Accent":
                            Intent intent4=new Intent(view.getContext(),RussianDialog4Activity.class);
                            //intent1.putExtra("FROM_PAGE","Main Dialog Page");
                            view.getContext().startActivity(intent4);
                            return;
                        case "A Rebel":
                            Intent intent5=new Intent(view.getContext(),RussianDialog5Activity.class);
                            //intent1.putExtra("FROM_PAGE","Main Dialog Page");
                            view.getContext().startActivity(intent5);
                            return;
                        case "A Rude Waiter":
                            Intent intent6=new Intent(view.getContext(),RussianDialog6Activity.class);
                            //intent1.putExtra("FROM_PAGE","Main Dialog Page");
                            view.getContext().startActivity(intent6);
                            return;
                        case "Stereotypes":
                            Intent intent7=new Intent(view.getContext(),RussianDialog7Activity.class);
                            //intent1.putExtra("FROM_PAGE","Main Dialog Page");
                            view.getContext().startActivity(intent7);
                            return;
                        case "A Wild Friend":
                            Intent intent8=new Intent(view.getContext(),RussianDialog8Activity.class);
                            //intent1.putExtra("FROM_PAGE","Main Dialog Page");
                            view.getContext().startActivity(intent8);
                            return;
                        case "A Very Boring Man":
                            Intent intent9=new Intent(view.getContext(),RussianDialog9Activity.class);
                            //intent1.putExtra("FROM_PAGE","Main Dialog Page");
                            view.getContext().startActivity(intent9);
                            return;
                        case "A Liar":
                            Intent intent14=new Intent(view.getContext(),RussianDialog14Activity.class);
                            //intent1.putExtra("FROM_PAGE","Main Dialog Page");
                            view.getContext().startActivity(intent14);
                            return;
                        case "Donald And Vladimir":
                            Intent intent13=new Intent(view.getContext(),RussianDialog13Activity.class);
                            //intent1.putExtra("FROM_PAGE","Main Dialog Page");
                            view.getContext().startActivity(intent13);
                            return;
                        case "Frustration":
                            Intent intent12=new Intent(view.getContext(),RussianDialog12Activity.class);
                            //intent1.putExtra("FROM_PAGE","Main Dialog Page");
                            view.getContext().startActivity(intent12);
                            return;
                        case "A Hidden Joke":
                            Intent intent10=new Intent(view.getContext(),RussianDialog11Activity.class);
                            //intent1.putExtra("FROM_PAGE","Main Dialog Page");
                            view.getContext().startActivity(intent10);
                            return;
                        case "True Love":
                            Intent intent11=new Intent(view.getContext(),RussianDialog10Activity.class);
                            //intent1.putExtra("FROM_PAGE","Main Dialog Page");
                            view.getContext().startActivity(intent11);
                            return;
                    }

                }
            });

            /*textView_title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    textView_title.setBackgroundColor(view.getResources().getColor(R.color.white_smoke));
                    view.getContext().startActivity(new Intent(view.getContext(),RussianLanguageActivity.class));
                }
            });*/


        }


        /*if(holder instanceof HeaderViewHolder){
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
                                categories.add(pos+1,"Alphabets");
                                categories.add(pos+2,"- Essentials 1 -");
                                categories.add(pos+3,"- Essentials 2 -");
                                categories.add(pos+4,"Vocab 1 - People");
                                categories.add(pos+5,"I Don't Understand");
                                categories.add(pos+6,"Nouns");
                                categories.add(pos+7,"A Pretty Woman");
                                categories.add(pos+8,"This Man, This Woman");
                                categories.add(pos+9,"Vocab 2 - Things");
                                categories.add(pos+10,"I Want");
                                categories.add(pos+11,"I Like");
                                notifyItemRangeInserted(pos+1, 11);
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
                                categories.add(pos+20,"A Pretty Lady's House");
                                notifyItemRangeInserted(pos+1, 20);
                            }
                            return;
                    }
                }
            });

        }*/
        //else if(holder instanceof ItemViewHolder){
        /*if(subject.equals("Essentials")){
                    holder.llayout.setBackgroundColor(view.getResources().getColor(R.color.yellow));
        //}

    }*/

    }


     //total number of rows
    @Override
    public int getItemCount() {
        return dialog_images.size();
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
        return dialog_images.get(id);
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
        String str=dialog_titles.get(position);
        if (str.equals("~ Beginner ~") || str.equals("~ Intermediate ~") || str.equals("~ Functional ~") ) {
            return TYPE_HEADER;
        }
        else{
            return TYPE_ITEM;
        }
    }

    /*private boolean isPositionHeader(int position) {
        String str=categories.get(position);
        return (str.equals("Beginner") || str.equals("Functional"));
    }*/
}

class HeaderDialogViewHolder extends RecyclerView.ViewHolder {
    TextView header_textview;

    public HeaderDialogViewHolder(View itemView) {
        super(itemView);
        header_textview = itemView.findViewById(R.id.dialog_header_text_view);

    }
}

class ItemDialogViewHolder extends RecyclerView.ViewHolder {
    TextView textView_image;
    TextView textView_title;
    LinearLayout layout;

    public ItemDialogViewHolder(View itemView) {
        super(itemView);
        textView_image = itemView.findViewById(R.id.image);
        textView_title=itemView.findViewById(R.id.title);
        layout=itemView.findViewById(R.id.layout);
    }
}

/*class VocabViewHolder extends RecyclerView.ViewHolder {
    TextView vocab_textview;
    LinearLayout vocab_llayout;

    public VocabViewHolder(View itemView) {
        super(itemView);
        vocab_textview = itemView.findViewById(R.id.vocab_text_view);
        vocab_llayout = itemView.findViewById(R.id.recycler_view_vocab_layout);
    }
}*/