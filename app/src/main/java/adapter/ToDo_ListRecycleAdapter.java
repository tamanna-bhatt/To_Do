package adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


import e.wolfsoft1.todo_app.Add_Task_Todo;
import e.wolfsoft1.todo_app.Home_Todo;
import e.wolfsoft1.todo_app.R;
import e.wolfsoft1.todo_app.Signup_Todo;
import e.wolfsoft1.todo_app.ToDo_login_main;
import e.wolfsoft1.todo_app.Today_task_todo;
import model.KwikListModelClass;


public class ToDo_ListRecycleAdapter extends RecyclerView.Adapter<ToDo_ListRecycleAdapter.MyViewHolder> {

    Context context;


    private List<KwikListModelClass> OfferList;


    public class MyViewHolder extends RecyclerView.ViewHolder {


        TextView title;


        public MyViewHolder(View view) {
            super(view);

            title = (TextView) view.findViewById(R.id.title);


        }

    }


    public ToDo_ListRecycleAdapter(Context context, List<KwikListModelClass> offerList) {
        this.OfferList = offerList;
        this.context = context;
    }

    @Override
    public ToDo_ListRecycleAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_todo_list, parent, false);


        return new ToDo_ListRecycleAdapter.MyViewHolder(itemView);


    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        KwikListModelClass lists = OfferList.get(position);
        holder.title.setText(lists.getTitle());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (position == 0) {
                    Intent i = new Intent(context, ToDo_login_main.class);
                    context.startActivity(i);
                }else if(position == 1) {
                    Intent i = new Intent(context, Signup_Todo.class);
                    context.startActivity(i);
                }else if(position == 2) {
                    Intent i = new Intent(context, Home_Todo.class);
                    context.startActivity(i);
                }else if(position == 3) {
                    Intent i = new Intent(context, Add_Task_Todo.class);
                    context.startActivity(i);
                }else if(position == 4) {
                    Intent i = new Intent(context, Today_task_todo.class);
                    context.startActivity(i);
                }

            }

        });


    }


    @Override
    public int getItemCount() {
        return OfferList.size();

    }

}


