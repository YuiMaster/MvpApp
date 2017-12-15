package com.yui.libbase.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Map;

/**
 * Created by Jane on 2017/11/27.
 * 简单的 SharePreference操作类,key-value存取工具
 *
 * @author Jane
 */

public class SharePreferenceUtil {
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;


    /**
     * 构造方法
     *
     * @param context
     * @param keyTableName 键值表名
     * @param mode         存储模式 Context.MODE_APPEND, Context.MODE_PRIVATE,
     *                     Context.WORLD_READABLE, Context.WORLD_WRITEABLE.
     * @param writeType    写入类型 true 默认为只读方式
     */
    public SharePreferenceUtil(Context context, String keyTableName, final int mode, final boolean writeType) {
        mSharedPreferences = context.getSharedPreferences(keyTableName, mode);
        if (writeType) {
            mEditor = mSharedPreferences.edit();
        }
    }

    /**
     * 获取保存着的boolean对象。
     *
     * @param key      键名
     * @param defValue 当不存在时返回的默认值。
     *
     * @return 返回获取到的值，当不存在时返回默认值。
     */
    public boolean getBoolean(String key, boolean defValue) {
        return mSharedPreferences.getBoolean(key, defValue);
    }

    /**
     * 获取保存着的int对象。
     *
     * @param key      键名
     * @param defValue 当不存在时返回的默认值。
     *
     * @return 返回获取到的值，当不存在时返回默认值。
     */
    public int getInt(String key, int defValue) {
        return mSharedPreferences.getInt(key, defValue);
    }

    /**
     * 获取保存着的long对象。
     *
     * @param key      键名
     * @param defValue 当不存在时返回的默认值。
     *
     * @return 返回获取到的值，当不存在时返回默认值。
     */
    public long getLong(String key, long defValue) {
        return mSharedPreferences.getLong(key, defValue);
    }

    /**
     * 获取保存着的float对象。
     *
     * @param key      键名
     * @param defValue 当不存在时返回的默认值。
     *
     * @return 返回获取到的值，当不存在时返回默认值。
     */
    public float getFloat(String key, float defValue) {
        return mSharedPreferences.getFloat(key, defValue);
    }

    /**
     * 获取保存着的String对象。
     *
     * @param key      键名
     * @param defValue 当不存在时返回的默认值。
     *
     * @return 返回获取到的值，当不存在时返回默认值。
     */
    public String getString(String key, String defValue) {
        return mSharedPreferences.getString(key, defValue);
    }

    /**
     * 获取所有键值对。
     *
     * @return 获取到的所胡键值对。
     */
    public Map<String, ?> getAll() {
        return mSharedPreferences.getAll();
    }

    /**
     * 设置一个键值对，它将在{@linkplain #commit()}被调用时保存。<br/>
     * 注意：当保存的value不是boolean, byte(会被转换成int保存),int, long, float,
     * String等类型时将调用它的toString()方法进行值的保存。
     *
     * @param key   键名称。
     * @param value 值。
     *
     * @return 引用的KV对象。
     */
    public SharePreferenceUtil put(String key, Object value) {

        if (value instanceof Boolean) {
            mEditor.putBoolean(key, (Boolean) value);
        } else if (value instanceof Integer || value instanceof Byte) {
            mEditor.putInt(key, (Integer) value);
        } else if (value instanceof Long) {
            mEditor.putLong(key, (Long) value);
        } else if (value instanceof Float) {
            mEditor.putFloat(key, (Float) value);
        } else if (value instanceof String) {
            mEditor.putString(key, (String) value);
        } else {
            if (value != null) {
                mEditor.putString(key, value.toString());
            }
        }
        return this;
    }

    /**
     * 移除键值对。
     *
     * @param key 要移除的键名称。
     *
     * @return 引用的KV对象。
     */
    public SharePreferenceUtil remove(String key) {
        mEditor.remove(key);
        return this;
    }

    /**
     * 清除所有键值对。
     *
     * @return 引用的KV对象。
     */
    public SharePreferenceUtil clear() {
        mEditor.clear();
        return this;
    }

    /**
     * 是否包含某个键。
     *
     * @param key 查询的键名称。
     *
     * @return 当且仅当包含该键时返回true, 否则返回false.
     */
    public boolean contains(String key) {
        return mSharedPreferences.contains(key);
    }

    /**
     * 返回是否提交成功。
     *
     * @return 当且仅当提交成功时返回true, 否则返回false.
     */
    public boolean commit() {
        return mEditor.commit();
    }
}
