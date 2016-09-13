package aaronchan.materialdesigndemo.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import aaronchan.materialdesigndemo.R;
import aaronchan.materialdesigndemo.activity.CollapsingActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycleListFragment extends Fragment {


    @BindView(R.id.recycle_view)
    RecyclerView mRecycleView;

    public RecycleListFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        ButterKnife.bind(this, view);
        setUpRecycleView();

        return view;
    }

    private void setUpRecycleView() {
        List<String> contentList = new ArrayList<>();
        List<Integer> imageIdList = new ArrayList<>();
        contentList.add("Beijing");
        contentList.add("Shenzhen");
        contentList.add("Shanghai");
        contentList.add("Chaozhou");
        contentList.add("Guangzhou");
        imageIdList.add(R.drawable.beijing);
        imageIdList.add(R.drawable.shenzhen);
        imageIdList.add(R.drawable.shanghai);
        imageIdList.add(R.drawable.chaozhou);
        imageIdList.add(R.drawable.guangzhou);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mRecycleView.setLayoutManager(linearLayoutManager);

        MyRecycleViewAdapter adapter = new MyRecycleViewAdapter(getContext(), contentList, imageIdList);
        adapter.setItemClickListener(new MyRecycleViewAdapter.ItemClickListener() {
            @Override
            public void onItemClick(int position, String place, View view) {
                Toast.makeText(getContext(), String.format(Locale.CHINA, "%d %s clicked", position, place), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), CollapsingActivity.class);
                startActivity(intent);
            }
        });
        mRecycleView.setAdapter(adapter);

    }

    static final class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.ViewHolder> {
        private Context mContext;
        private List<Integer> mImageIdList;
        private List<String> mContentList;
        private ItemClickListener mItemClickListener;

        interface ItemClickListener {
            void onItemClick(int position, String place, View view);
        }

        public void setItemClickListener(ItemClickListener itemClickListener) {
            mItemClickListener = itemClickListener;
        }

        public MyRecycleViewAdapter(Context context, List<String> contentList, List<Integer> imageIdList) {
            mContentList = contentList;
            mImageIdList = imageIdList;
            this.mContext = context;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_place, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.mTextView.setText(mContentList.get(position));
            int resId = mImageIdList.get(position);
            Bitmap bitmap = BitmapFactory.decodeResource(mContext.getResources(), resId);

            Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
                @Override
                public void onGenerated(Palette palette) {
                    //noinspection ResourceType
                    holder.mTextView.setBackgroundColor(palette.getVibrantColor(Color.BLACK));
                }
            });
            Picasso.with(mContext)
                    .load(resId)
                    .resize(1000, 800)
                    .into(holder.mImagePlace);
        }

        @Override
        public int getItemCount() {
            return mContentList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            public TextView mTextView;
            private final ImageView mImagePlace;

            public ViewHolder(View itemView) {
                super(itemView);
                itemView.setOnClickListener(this);
                mTextView = (TextView) itemView.findViewById(R.id.tv_name);
                mImagePlace = (ImageView) itemView.findViewById(R.id.image_place);
            }

            @Override
            public void onClick(View v) {
                if (mItemClickListener != null) {
                    int adapterPosition = getAdapterPosition();
                    mItemClickListener.onItemClick(adapterPosition, mContentList.get(adapterPosition), v);
                }
            }
        }
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }


}
