package adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

import DataLayer.TodoDatabase;
import e.wolfsoft1.todo_app.ToDoApp.Home_Todo;
import e.wolfsoft1.todo_app.ToDoApp.R;
import itemtouchhelperextension.Extension;
import itemtouchhelperextension.ItemTouchHelperExtension;
import model.WorklistModel;


public class MainRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int ITEM_TYPE_RECYCLER_WIDTH = 1000;
    public static final int ITEM_TYPE_ACTION_WIDTH = 1001;
    public static final int ITEM_TYPE_ACTION_WIDTH_NO_SPRING = 1002;
    public static final int ITEM_TYPE_NO_SWIPE = 1003;
    private  ArrayList<WorklistModel> mDatas;
    private Context mContext;
    private ItemTouchHelperExtension mItemTouchHelperExtension;
    public MainRecyclerAdapter(Context context) {
        mDatas = new ArrayList<>();
        mContext = context;
    }

    public void setDatas(ArrayList<WorklistModel> datas) {
        mDatas.clear();
        mDatas.addAll(datas);
    }

//    public  ArrayList<WorklistModel> setDatas(ArrayList<WorklistModel> arrayList,WorklistModel wm) {
//        if(arrayList == null)
//            arrayList = new ArrayList<>();
//        arrayList.add(wm);
//        mDatas = arrayList;
//        //this.notifyItemInserted(mDatas.size());
//        return mDatas;
//    }

    public void updateData(ArrayList<WorklistModel> datas) {
        setDatas(datas);
        //notifyDataSetChanged();
    }
//public void updateData(List<WorklistModel> datas,WorklistModel wm) {
//        //setDatas(wm);
//}

    public void setItemTouchHelperExtension(ItemTouchHelperExtension itemTouchHelperExtension) {
        mItemTouchHelperExtension = itemTouchHelperExtension;
    }

    private LayoutInflater getLayoutInflater() {
        return LayoutInflater.from(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = getLayoutInflater().inflate(R.layout.list_item_main, parent, false);
        if (viewType == ITEM_TYPE_ACTION_WIDTH) return new ItemSwipeWithActionWidthViewHolder(view);
        if (viewType == ITEM_TYPE_NO_SWIPE) return new ItemNoSwipeViewHolder(view);
        if (viewType == ITEM_TYPE_RECYCLER_WIDTH) {
            view = getLayoutInflater().inflate(R.layout.list_item_with_single_delete, parent, false);
            return new ItemViewHolderWithRecyclerWidth(view);
        }
        return new ItemSwipeWithActionWidthNoSpringViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        final WorklistModel worklistModel=mDatas.get(position);
        final ItemBaseViewHolder baseViewHolder = (ItemBaseViewHolder) holder;
        baseViewHolder.bind(mDatas.get(position));

        baseViewHolder.ovalblue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(mContext);
                if(worklistModel.isSelected() == false) {
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
                        if(worklistModel.isSelected()==false){

                            baseViewHolder.lineblue.setImageResource(R.drawable.rect_blue_line);
                            baseViewHolder.ovalblue.setImageResource(R.drawable.ic_oval_blue);
                            worklistModel.setSelected(false);


                        }

                        else
                        {
                            baseViewHolder.lineblue.setImageResource(R.drawable.rect_red_line);
                            baseViewHolder.ovalblue.setImageResource(R.drawable.checked);
                            worklistModel.setSelected(true);

                        }
                        dialog.cancel();
                    }
                });
                alertDialog.setNegativeButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        TodoDatabase td = new TodoDatabase(mContext);
                        if(worklistModel.isSelected()==false) {
                            baseViewHolder.lineblue.setImageResource(R.drawable.rect_red_line);
                            baseViewHolder.ovalblue.setImageResource(R.drawable.checked);
                            worklistModel.setSelected(true);
                            td.updateTask(worklistModel, false);
                            Home_Todo hd = (Home_Todo)mContext;
                            hd.updateDoneCount(td.getCountofisDone());
                            hd.updateisLiveCount(td.getCountofisLive());
                        }
                        else
                        {
                            baseViewHolder.lineblue.setImageResource(R.drawable.rect_blue_line);
                            baseViewHolder.ovalblue.setImageResource(R.drawable.ic_oval_blue);
                            worklistModel.setSelected(false);
                            td.updateTask(worklistModel,true);
                            Home_Todo hd = (Home_Todo)mContext;
                            hd.updateDoneCount(td.getCountofisDone());
                            hd.updateisLiveCount(td.getCountofisLive());
                        }



                    }
                });

                AlertDialog dialog = alertDialog.create();
                dialog.show();


            }
        });
        if (holder instanceof ItemViewHolderWithRecyclerWidth) {
            ItemViewHolderWithRecyclerWidth viewHolder = (ItemViewHolderWithRecyclerWidth) holder;
//            viewHolder.mActionViewDelete.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    TodoDatabase todoDatabase = new TodoDatabase(mContext);
//                    doDelete(holder.getAdapterPosition(),todoDatabase);
//                }
//            });
        } else if (holder instanceof ItemSwipeWithActionWidthViewHolder) {
            ItemSwipeWithActionWidthViewHolder viewHolder = (ItemSwipeWithActionWidthViewHolder) holder;

            viewHolder.mActionViewDelete.setOnClickListener(


                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            TodoDatabase todoDatabase = new TodoDatabase(mContext);
                            doDelete(holder.getAdapterPosition(),todoDatabase);
                        }
                    }

            );
        }
    }

    private void doDelete(int adapterPosition,TodoDatabase todoDatabase) {

        Log.e("msg","clicked");
        if(todoDatabase != null)
            todoDatabase.delectSingleEntry(mDatas.get(adapterPosition));
        mDatas.remove(adapterPosition);
        notifyItemRemoved(adapterPosition);
    }

    public void move(int from, int to) {
        WorklistModel prev = mDatas.remove(from);
        mDatas.add(to > from ? to - 1 : to, prev);
        notifyItemMoved(from, to);
    }

    @Override
    public int getItemViewType(int position) {
//      if (mDatas.get(position).position == position) {
//         return ITEM_TYPE_ACTION_WIDTH_NO_SPRING;
//      }
//        if (mDatas.get(position).position == 2) {
//            return ITEM_TYPE_RECYCLER_WIDTH;
//        }
//        if (mDatas.get(position).position == 3) {
//            return ITEM_TYPE_NO_SWIPE;
//        }
        return ITEM_TYPE_ACTION_WIDTH;
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public class ItemBaseViewHolder extends RecyclerView.ViewHolder {
        TextView mTextIndex, mTextTitle;

       public View mViewContent;
        public View mActionContainer;
        ImageView ovalblue,lineblue;


        public ItemBaseViewHolder(View itemView) {
            super(itemView);
            mTextTitle = (TextView) itemView.findViewById(R.id.tvActivityInfo);
            mTextIndex = (TextView) itemView.findViewById(R.id.time);
            ovalblue=itemView.findViewById(R.id.ovalblue);
            lineblue=itemView.findViewById(R.id.lineblue);

            mViewContent = itemView.findViewById(R.id.view_list_main_content);
            mActionContainer = itemView.findViewById(R.id.view_list_repo_action_container);
        }

        public void bind(WorklistModel testModel) {
            mTextTitle.setText(testModel.activityName);
            mTextIndex.setText(testModel.time);
            Log.e("isLive",String.valueOf(testModel.isLive));
            if(testModel.getisLive()== false) {
                testModel.selected = true;
                ovalblue.setImageResource(R.drawable.checked);
                lineblue.setImageResource(R.drawable.rect_red_line);
            }
            else {
                testModel.selected = false;
                ovalblue.setImageResource(R.drawable.ic_oval_blue);
                lineblue.setImageResource(R.drawable.rect_blue_line);
            }

            /*initialletter.setText(testModel.initialletter);
            timeperiod.setText(testModel.timeperiod);*/


            itemView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (MotionEventCompat.getActionMasked(event) == MotionEvent.ACTION_DOWN) {
                        mItemTouchHelperExtension.startDrag(ItemBaseViewHolder.this);
                    }
                    return true;
                }
            });
        }
    }


    class ItemViewHolderWithRecyclerWidth extends ItemBaseViewHolder {

        View mActionViewDelete;

        public ItemViewHolderWithRecyclerWidth(View itemView) {
            super(itemView);
            mActionViewDelete = itemView.findViewById(R.id.view_list_repo_action_delete);
        }

    }

    class ItemSwipeWithActionWidthViewHolder extends ItemBaseViewHolder implements Extension {

        View mActionViewDelete;
        View mActionViewRefresh;

        public ItemSwipeWithActionWidthViewHolder(View itemView) {
            super(itemView);
            mActionViewDelete = itemView.findViewById(R.id.view_list_repo_action_delete);
         //  mActionViewRefresh = itemView.findViewById(R.id.view_list_repo_action_update);
        }

        @Override
        public float getActionWidth() {
            return mActionContainer.getWidth();
        }
    }

    public class ItemSwipeWithActionWidthNoSpringViewHolder extends ItemSwipeWithActionWidthViewHolder implements Extension {

        public ItemSwipeWithActionWidthNoSpringViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public float getActionWidth() {
            return mActionContainer.getWidth();
        }
    }

   public class ItemNoSwipeViewHolder extends ItemBaseViewHolder {

        public ItemNoSwipeViewHolder(View itemView) {
            super(itemView);
        }
    }

}