package com.project.semicolon.eduactive.databinding;
import com.project.semicolon.eduactive.R;
import com.project.semicolon.eduactive.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class NewsListItemBindingImpl extends NewsListItemBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public NewsListItemBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }
    private NewsListItemBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[4]
            , (android.widget.ImageView) bindings[1]
            , (android.widget.LinearLayout) bindings[0]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[2]
            );
        this.date.setTag(null);
        this.image.setTag(null);
        this.lytParent.setTag(null);
        this.subtitle.setTag(null);
        this.title.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.news == variableId) {
            setNews((adapters.News) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setNews(@Nullable adapters.News News) {
        this.mNews = News;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.news);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        adapters.News news = mNews;
        java.lang.String newsDate = null;
        int newsImage = 0;
        java.lang.String newsCategory = null;
        java.lang.String newsTitle = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (news != null) {
                    // read news.date
                    newsDate = news.getDate();
                    // read news.image
                    newsImage = news.getImage();
                    // read news.category
                    newsCategory = news.getCategory();
                    // read news.title
                    newsTitle = news.getTitle();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.date, newsDate);
            androidx.databinding.adapters.ImageViewBindingAdapter.setImageDrawable(this.image, androidx.databinding.adapters.Converters.convertColorToDrawable(newsImage));
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.subtitle, newsCategory);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.title, newsTitle);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): news
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}