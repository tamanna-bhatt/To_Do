package adapter;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import DataLayer.TodoDatabase;
import ToDoApp.R;
import model.WorklistModel;

public class TodaytaskAdapter extends RecyclerView.Adapter<TodaytaskAdapter.MyViewHolder> {

    boolean showingfirst = true;
    Context context;

    int myPos = 0;
    private ArrayList<WorklistModel>todotodaytaskModelArrayList;

    public TodaytaskAdapter(Context context, ArrayList<WorklistModel> todotodaytaskModelArrayList) {
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
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        final WorklistModel todayrecycler = todotodaytaskModelArrayList.get(position);


        //holder.tododottedimg.setImageResource(modelfoodrecycler.getTodoimg());


        holder.activityType.setText(todayrecycler.getActivityType());
        holder.activityName.setText(todayrecycler.getActivityName());
        holder.activityDesc.setText(todayrecycler.getActivityDesc());
       // holder.date.setText(todayrecycler.getDate());
        holder.time.setText(todayrecycler.getTime());
        todayrecycler.selected = !todayrecycler.isLive;
        if(todayrecycler.selected)
            holder.checkBox.setImageResource(R.drawable.ic_check_mark);



        /*if(position==3){
            holder.tododottedimg.setVisibility(View.GONE);
        }
        else {
            holder.tododottedimg.setVisibility(View.VISIBLE);
        }*/


        //holder.radio.setButtonTintList(modelfoodrecycler.getRadio());




        if (holder.activityType.getText().equals("Work")){
            holder.activityName.setTextColor(Color.parseColor("#fe7d1f"));
            holder.activityType.setTextColor(Color.parseColor("#fe7d1f"));
            holder.todoimg.setBackgroundResource(R.drawable.todaytaskorange_ract);

            // holder.hoteltext1.setBackgroundResource(Color.parseColor("ffffff"));
        }else if(holder.activityType.getText().equals("Personal")){

            holder.activityName.setTextColor(Color.parseColor("#8e5cdd"));
            holder.activityType.setTextColor(Color.parseColor("#8e5cdd"));
            holder.todoimg.setBackgroundResource(R.drawable.todaytaskpurple_ract);
            // holder.hoteltext1.setBackgroundColor(Color.parseColor("#00000000"));
        }else if(holder.activityType.getText().equals("Health")) {

            holder.activityName.setTextColor(Color.parseColor("#1377ec"));
            holder.activityType.setTextColor(Color.parseColor("#1377ec"));
            holder.todoimg.setBackgroundResource(R.drawable.todaytaskblue_ract);
        }

        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
                if(todayrecycler.isSelected() == false) {
                    alertDialog.setTitle("Completed Task !");
                    alertDialog.setMessage("Are you sure you have completed your task ? ");
                }
                else{
                    alertDialog.setTitle("Undo Task !");
                    alertDialog.setMessage("Are you sure you want to undo task? ");
                }
                alertDialog.setPositiveButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(todayrecycler.isSelected()==false){

                            holder.checkBox.setImageResource(R.drawable.ic_unchecked);

                            todayrecycler.setSelected(false);


                        }

                        else
                        {
                            holder.checkBox.setImageResource(R.drawable.ic_check_mark);

                            todayrecycler.setSelected(true);

                        }
                        dialog.cancel();
                    }
                });
                alertDialog.setNegativeButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        TodoDatabase td = new TodoDatabase(context);
                        if(todayrecycler.isSelected()==false) {
                            holder.checkBox.setImageResource(R.drawable.ic_check_mark);

                            todayrecycler.setSelected(true);
                            td.updateTask(todayrecycler, false);





                        }
                        else
                        {

                            holder.checkBox.setImageResource(R.drawable.ic_unchecked);
                            todayrecycler.setSelected(false);
                            td.updateTask(todayrecycler, true);
                          //  Home_Todo hd = new Home_Todo();



                        }



                    }
                });

                AlertDialog dialog = alertDialog.create();
                dialog.show();


            }
        });



//        holder.checkBox.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//                AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
//                if(holder.checkBox.isChecked()==false) {
//                    alertDialog.setTitle("Completed Task !");
//                    alertDialog.setMessage("Are you sure you have completed your task ? ");
//                }
//                else{
//                    alertDialog.setTitle("Undo Task !");
//                    alertDialog.setMessage("Are you sure you want to undo task? ");
//
//                }
//                alertDialog.setPositiveButton("CANCEL", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                        if(holder.checkBox.isChecked() == false)
//                         holder.checkBox.setChecked(false);
//                        else if(holder.checkBox.isChecked() == true)
//                            holder.checkBox.setChecked(true);
//
//
//
//
//                        dialog.cancel();
//                    }
//                });
//                alertDialog.setNegativeButton("YES", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                        if(todayrecycler.isSelected() == false)
//                            holder.checkBox.setChecked(true);
//
//                        else if (todayrecycler.isSelected() == true)
//                            holder.checkBox.setChecked(true);
//
//
//
//
//
//                    }
//                });
//
//                AlertDialog dialog = alertDialog.create();
//                dialog.show();
//
//
//            }
//        });


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
//            holder.activityName.setTextColor(Color.parseColor("#1377ec"));
//
//            // holder.hoteltext1.setBackgroundResource(Color.parseColor("ffffff"));
//        }else {
//
//            holder.activityName.setTextColor(Color.parseColor("#26b63a"));
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




//        if (position == 0){
//            holder.todoimg.setBackgroundResource(R.drawable.todaytaskorange_ract);
//        //   holder.radio.setButtonTintList(colorStateList1);//set the color tint list
//
//
//            // holder.hoteltext1.setBackgroundResource(Color.parseColor("ffffff"));
//        }else if(position == 1){
//
//            holder.todoimg.setBackgroundResource(R.drawable.todaytaskblue_ract);
//           // holder.radio.setButtonTintList(colorStateList);//set the color tint list
//
//            // holder.hoteltext1.setBackgroundColor(Color.parseColor("#00000000"));
//        }else if(position == 2) {
//
//
//            holder.todoimg.setBackgroundResource(R.drawable.todaytaskorange_ract);
//        }else if(position == 3) {
//
//            holder.todoimg.setBackgroundResource(R.drawable.todaytaskpurple_ract);
//            //holder.radio.setButtonTintList(colorStateList2);//set the color tint list
//
//
//        }


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
        TextView activityType, activityName, activityDesc, date, time;
       ImageView todoimg,tododottedimg,todoimg2;
       ImageView checkBox;
     //   RadioButton radio;
        public MyViewHolder(View itemView) {
            super(itemView);


            activityType = (itemView).findViewById(R.id.activityType);
            activityName = (itemView).findViewById(R.id.activityName);
            activityDesc = (itemView).findViewById(R.id.activityDesc);
            time = (itemView).findViewById(R.id.time);

            tododottedimg = (itemView).findViewById(R.id.tododottedimg);
            todoimg = (itemView).findViewById(R.id.cardcolor);
            checkBox = (itemView).findViewById(R.id.checkbox);




        }
    }
}
