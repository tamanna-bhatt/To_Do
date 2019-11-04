package adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatRadioButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

import e.wolfsoft1.todo_app.R;
import model.TodotodaytaskModel;

public class TodaytaskAdapter extends RecyclerView.Adapter<TodaytaskAdapter.MyViewHolder> {

    boolean showingfirst = true;
    Context context;

    int myPos = 0;
    private ArrayList<TodotodaytaskModel>todotodaytaskModelArrayList;

    public TodaytaskAdapter(Context context, ArrayList<TodotodaytaskModel> todotodaytaskModelArrayList) {
        this.context = context;
        this.todotodaytaskModelArrayList = todotodaytaskModelArrayList;
    }

    @NonNull
    @Override
    public TodaytaskAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.today_item, parent, false);
        return new TodaytaskAdapter.MyViewHolder(view);
    }


    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(@NonNull final TodaytaskAdapter.MyViewHolder holder, final int position) {
        TodotodaytaskModel modelfoodrecycler = todotodaytaskModelArrayList.get(position);

        holder.todoimg.setImageResource(modelfoodrecycler.getTodoimg());
        holder.todoimg2.setImageResource(modelfoodrecycler.getTodoimg2());
        //holder.tododottedimg.setImageResource(modelfoodrecycler.getTodoimg());


        holder.todotext.setText(modelfoodrecycler.getTodotext());
        holder.todotext2.setText(modelfoodrecycler.getTodotext2());
        holder.todotext3.setText(modelfoodrecycler.getTodotext3());
        holder.todotext4.setText(modelfoodrecycler.getTodotext4());
        holder.todotext5.setText(modelfoodrecycler.getTodotext5());

        if(position==3){
            holder.tododottedimg.setVisibility(View.GONE);
        }
        else {
            holder.tododottedimg.setVisibility(View.VISIBLE);
        }


        //holder.radio.setButtonTintList(modelfoodrecycler.getRadio());




        if (position == 0){
            holder.todotext2.setTextColor(Color.parseColor("#fe7d1f"));

            // holder.hoteltext1.setBackgroundResource(Color.parseColor("ffffff"));
        }else if(position == 1){

            holder.todotext2.setTextColor(Color.parseColor("#1377ec"));
            // holder.hoteltext1.setBackgroundColor(Color.parseColor("#00000000"));
        }else if(position == 2) {

            holder.todotext2.setTextColor(Color.parseColor("#fe7d1f"));
        }else if(position == 3) {

            holder.todotext2.setTextColor(Color.parseColor("#8e5cdd"));

        }
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                myPos = position;
//                notifyDataSetChanged();
//
//            }
//
//
//        });


//        if (myPos == 1){
//            holder.todotext2.setTextColor(Color.parseColor("#1377ec"));
//
//            // holder.hoteltext1.setBackgroundResource(Color.parseColor("ffffff"));
//        }else {
//
//            holder.todotext2.setTextColor(Color.parseColor("#26b63a"));
//            // holder.hoteltext1.setBackgroundColor(Color.parseColor("#00000000"));
//        }
//
//
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                myPos = position;
//                notifyDataSetChanged();
//
//            }
//
//
//        });

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                myPos = position;
//                notifyDataSetChanged();
//
//            }
//        });
//
//        ColorStateList colorStateList = new ColorStateList(
//                new int[][]{
//
//                        new int[]{-android.R.attr.state_enabled}, //disabled
//                        new int[]{android.R.attr.state_enabled} //enabled
//                },
//                new int[] {
//
//                        Color.YELLOW //disabled
//                        ,Color.BLUE //enabled
//
//                }
//        );
//
//        ColorStateList colorStateList1 = new ColorStateList(
//                new int[][]{
//
//                        new int[]{-android.R.attr.state_enabled}, //disabled
//                        new int[]{android.R.attr.state_enabled} //enabled
//                },
//                new int[] {
//
//                        Color.parseColor("#616161")//disabled
//                        ,Color.parseColor("#fe7d1f") //enabled
//
//                }
//        );

//        ColorStateList colorStateList2 = new ColorStateList(
//                new int[][]{
//
//                        new int[]{-android.R.attr.state_enabled}, //disabled
//                        new int[]{android.R.attr.state_enabled} //enabled
//                },
//                new int[] {
//
//                        Color.parseColor("#616161")//disabled
//                        ,Color.parseColor("#8e5cdd") //enabled
//
//                }
//        );




        if (position == 0){
            holder.todoimg.setBackgroundResource(R.drawable.todaytaskorange_ract);
        //   holder.radio.setButtonTintList(colorStateList1);//set the color tint list


            // holder.hoteltext1.setBackgroundResource(Color.parseColor("ffffff"));
        }else if(position == 1){

            holder.todoimg.setBackgroundResource(R.drawable.todaytaskblue_ract);
           // holder.radio.setButtonTintList(colorStateList);//set the color tint list

            // holder.hoteltext1.setBackgroundColor(Color.parseColor("#00000000"));
        }else if(position == 2) {


            holder.todoimg.setBackgroundResource(R.drawable.todaytaskorange_ract);
        }else if(position == 3) {

            holder.todoimg.setBackgroundResource(R.drawable.todaytaskpurple_ract);
            //holder.radio.setButtonTintList(colorStateList2);//set the color tint list


        }


//        if (position == 0){
//            holder.radio.setBackgroundResource(Color.parseColor("#8e5cdd"));
//
//            // holder.hoteltext1.setBackgroundResource(Color.parseColor("ffffff"));
//        }else if(position == 1){
//
//            holder.radio.setBackgroundResource(Color.parseColor("#8e5cdd"));
//            // holder.hoteltext1.setBackgroundColor(Color.parseColor("#00000000"));
//        }else if(position == 2) {
//
//            holder.radio.setBackgroundResource(Color.parseColor("#1377ec"));
//        }else if(position == 3) {
//
//            holder.radio.setBackgroundResource(Color.parseColor("#8e5cdd"));
//
//        }






    }

    @Override
    public int getItemCount() {
        return todotodaytaskModelArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView todotext,todotext2,todotext3,todotext4,todotext5;
       ImageView todoimg,tododottedimg,todoimg2;
     //   RadioButton radio;
        public MyViewHolder(View itemView) {
            super(itemView);


            todotext = (itemView).findViewById(R.id.todotext);
            todotext2 = (itemView).findViewById(R.id.todotext2);
            todotext3 = (itemView).findViewById(R.id.todotext3);
            todotext4 = (itemView).findViewById(R.id.todotext4);
            todotext5 = (itemView).findViewById(R.id.todotext5);

            tododottedimg = (itemView).findViewById(R.id.tododottedimg);
            todoimg = (itemView).findViewById(R.id.todoimg);
            todoimg2 = (itemView).findViewById(R.id.todoimg2);



        }
    }
}
