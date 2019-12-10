package www.androwheels.com.satishkumar.mycameraapp.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import www.androwheels.com.satishkumar.mycameraapp.R;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolderClass> {
    private Context context;
    private List<String> files;

    public ImageAdapter(Context context, List<String> files) {
        this.context = context;
        this.files = files;
    }

    @NonNull
    @Override
    public ViewHolderClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolderClass(LayoutInflater.from(context).inflate(R.layout.gallery_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderClass holder, int position) {
        Bitmap myBitmap = BitmapFactory.decodeFile(files.get(position));
        holder.galleryImage.setImageBitmap(myBitmap);
       // Glide.with(context).load(myBitmap).into(holder.galleryImage);
    }

    @Override
    public int getItemCount() {
        if (files != null) {
            return files.size();
        } else {
            return 0;
        }
    }

    public class ViewHolderClass extends RecyclerView.ViewHolder {
        ImageView galleryImage;

        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);
            galleryImage = itemView.findViewById(R.id.gallery_image);
        }
    }
}
