package edisontkp.com.justpark.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.ArrayList;

import edisontkp.com.justpark.HistoryActivity;
import edisontkp.com.justpark.R;

/**
 * Created by edisontkp on 16/10/2016.
 */

public class HistoryListAdapter {
//    private ImageLoader mImageLoader;
//
//    private ArrayList<String> result;
//    Context context;
//    ArrayList<String> imageId;
//    private static LayoutInflater inflater=null;
//    public HistoryListAdapter(Topup topup, ArrayList<String> prgmNameList, ArrayList<String> prgmImages) {
//        result=prgmNameList;
//        context=topup;
//        imageId=prgmImages;
//        inflater = ( LayoutInflater )context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//    }
//    @Override
//    public int getCount() {
//        return result.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return position;
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    public class Holder
//    {
//        TextView tv;
//        ImageView img;
//    }
//    @Override
//    public View getView(final int position, View convertView, ViewGroup parent) {
//        Holder holder=new Holder();
//        View rowView;
//        rowView = inflater.inflate(R.layout.channel_item, null);
//        holder.tv=(TextView) rowView.findViewById(R.id.textView1);
////        holder.img=(ImageView) rowView.findViewById(R.id.imageView1);
//        holder.tv.setText(result.get(position));
//        ImageLoader imageLoader = MySingleton.getInstance(context).getImageLoader();
//
//        if (imageLoader == null)
//            imageLoader =  MySingleton.getInstance(context).getImageLoader();
//        NetworkImageView thumbNail = (NetworkImageView) rowView.findViewById(R.id.imageView1);
//
//        thumbNail.setImageUrl(imageId.get(position), imageLoader);
////        holder.img.setImageResource(imageId.get(position));
//
//        return rowView;
//    }

//    String [] result;
//    Context context;
//    int [] imageId;
//    private static LayoutInflater inflater=null;
//    public HistoryListAdapter(HistoryActivity mainActivity, String[] prgmNameList) {
//        // TODO Auto-generated constructor stub
//        result=prgmNameList;
//        context=mainActivity;
//        inflater = ( LayoutInflater )context.
//                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//    }
//    @Override
//    public int getCount() {
//        // TODO Auto-generated method stub
//        return result.length;
//    }
//
//    @Override
//    public Object getItem(int position) {
//        // TODO Auto-generated method stub
//        return position;
//    }
//
//    @Override
//    public long getItemId(int position) {
//        // TODO Auto-generated method stub
//        return position;
//    }
//
//    public class Holder
//    {
//        TextView tv;
//    }
//    @Override
//    public View getView(final int position, View convertView, ViewGroup parent) {
//        // TODO Auto-generated method stub
//        Holder holder=new Holder();
//        View rowView;
//        rowView = inflater.inflate(R.layout.history_item, null);
//        holder.tv=(TextView) rowView.findViewById(R.id.textView1);
//        holder.tv.setText(result[position]);
//        rowView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//                Toast.makeText(context, "You Clicked "+result[position], Toast.LENGTH_LONG).show();
//            }
//        });
//        return rowView;
//    }
}
