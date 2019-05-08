package com.example.immanuel.flashtalk;

/*public class CustomAdapterAlphabet extends ArrayAdapter<String> {

    private Context mContext;
    //private int resource;
    private String[] alphabets;
    private String[] transliterations;
    int done=0;
    Bitmap resizedBitmap;

    public CustomAdapterAlphabet(Context context,String[] alph,String[] trans) {
        super(context,0,alph);
        //resource=res;
        this.mContext = context;
        this.alphabets=alph;
        this.transliterations=trans;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        if(v == null) {
            v = LayoutInflater.from(mContext).inflate(R.layout.alphabet_rowview, parent, false);
        }

        //Toast.makeText(getContext(),alphabets[0], Toast.LENGTH_LONG).show();
        String letter=alphabets[position];
        String translit=transliterations[position];
        TextView t1=(TextView)v.findViewById(R.id.letter);
        TextView t2=(TextView)v.findViewById(R.id.transliteration);
        TextView t3=(TextView)v.findViewById(R.id.audio_img);
        /*if(letter==""){
            t1.setVisibility(View.INVISIBLE);
            t2.setVisibility(View.INVISIBLE);
            t3.setVisibility(View.INVISIBLE);
        }*/
        /*t1.setText(letter);
        t2.setText(translit);
        if(letter==""){
            v.setBackgroundColor(getContext().getResources().getColor(R.color.red));
        }*/

        //ImageView audio_img = (ImageView) v.findViewById(R.id.audio_img);
        //Picasso.with(getContext()).load(R.drawable.volume2).into(audio_img);
        /*if(done==0) {


            Bitmap bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.audio1);
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int requiredWidth = 0;
            int requiredHeight = 0;
            Matrix matrix = new Matrix();

            float a = (float) 1.0 * requiredWidth / width;
            float b = (float) 1.0 * requiredHeight / height;

            matrix.postScale(a, b);
            Bitmap resizedBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);

        /*ByteArrayOutputStream out = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
        Bitmap decoded = BitmapFactory.decodeStream(new ByteArrayInputStream(out.toByteArray()));*/
            //done=1;
        //}

        //audio_img.setImageBitmap(resizedBitmap);

        //return v;
    //}

//}