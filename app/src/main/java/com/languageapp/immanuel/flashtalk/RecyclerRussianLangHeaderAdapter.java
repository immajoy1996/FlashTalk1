package com.languageapp.immanuel.flashtalk;

/*public class RecyclerRussianLangHeaderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    ArrayList<String>data;

    public RecyclerRussianLangHeaderAdapter(ArrayList<String> data) {
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM) {
            //inflate your layout and pass it to view holder
            View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_layout, parent, false);
            return new ViewHolderItem(null);
        } else if (viewType == TYPE_HEADER) {
            //inflate your layout and pass it to view holder
            View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_layout, parent, false);
            return new ViewHolderHeader(null);
        }

        throw new RuntimeException("there is no type that matches the type " + viewType + " + make sure your using types correctly");
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolderItem) {
            String dataItem = getItem(position);
            //cast holder to VHItem and set data
        } else if (holder instanceof ViewHolderHeader) {
            //cast holder to VHHeader and set data for header.
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position))
            return TYPE_HEADER;

        return TYPE_ITEM;
    }

    private boolean isPositionHeader(int position) {
        return position == 0;
    }

    private String getItem(int position) {
        return data.get(position);
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder {
        TextView title;

        public ViewHolderItem(View itemView) {
            super(itemView);
        }
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView title;

        public ViewHolderHeader(View itemView) {
            super(itemView);
        }
    }
}*/