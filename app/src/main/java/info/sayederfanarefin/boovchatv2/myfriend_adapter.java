package info.sayederfanarefin.boovchatv2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by SayedErfan on 8/10/2015.
 */
public class myfriend_adapter extends ArrayAdapter<friendsss> {
    Context mContext;

    /**
     * Adapter View layout
     */
    int mLayoutResourceId;

    public myfriend_adapter(Context context, int layoutResourceId) {
        super(context, layoutResourceId);

        mContext = context;
        mLayoutResourceId = layoutResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        final friendsss currentItem = getItem(position);

        if (row == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            row = inflater.inflate(R.layout.activity_friends_display_unit, parent, false);
        }

        row.setTag(currentItem);

        final TextView tv = (TextView) row.findViewById(R.id.textView_friend_name_display_unit);
        tv.setText(currentItem.friend2);
        final Button chat_button = (Button) row.findViewById(R.id.button_chat);
        chat_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mContext instanceof Friends) {
                    Friends activity = (Friends) mContext;
                    activity.chat_window(currentItem);
                }

            }
        });

        return row;
    }
}
