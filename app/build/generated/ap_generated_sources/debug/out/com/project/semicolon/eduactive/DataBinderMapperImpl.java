package com.project.semicolon.eduactive;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.project.semicolon.eduactive.databinding.LoginFragmentBindingImpl;
import com.project.semicolon.eduactive.databinding.NewsListItemBindingImpl;
import com.project.semicolon.eduactive.databinding.StudyTimeTableItemBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_FRAGMENTLOGIN = 1;

  private static final int LAYOUT_NEWSLISTITEM = 2;

  private static final int LAYOUT_STUDYTIMETABLEITEM = 3;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(3);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.project.semicolon.eduactive.R.layout.fragment_login, LAYOUT_FRAGMENTLOGIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.project.semicolon.eduactive.R.layout.news_list_item, LAYOUT_NEWSLISTITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.project.semicolon.eduactive.R.layout.study_time_table_item, LAYOUT_STUDYTIMETABLEITEM);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_FRAGMENTLOGIN: {
          if ("layout/fragment_login_0".equals(tag)) {
            return new LoginFragmentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_login is invalid. Received: " + tag);
        }
        case  LAYOUT_NEWSLISTITEM: {
          if ("layout/news_list_item_0".equals(tag)) {
            return new NewsListItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for news_list_item is invalid. Received: " + tag);
        }
        case  LAYOUT_STUDYTIMETABLEITEM: {
          if ("layout/study_time_table_item_0".equals(tag)) {
            return new StudyTimeTableItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for study_time_table_item is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(4);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "news");
      sKeys.put(2, "model");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(3);

    static {
      sKeys.put("layout/fragment_login_0", com.project.semicolon.eduactive.R.layout.fragment_login);
      sKeys.put("layout/news_list_item_0", com.project.semicolon.eduactive.R.layout.news_list_item);
      sKeys.put("layout/study_time_table_item_0", com.project.semicolon.eduactive.R.layout.study_time_table_item);
    }
  }
}
