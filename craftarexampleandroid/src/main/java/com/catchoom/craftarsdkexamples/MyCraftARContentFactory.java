package com.catchoom.craftarsdkexamples;

/**
 * Created by elena on 28/11/16.
 */
import com.craftar.CraftARContentFactory;
import com.craftar.CraftARContent;
import com.craftar.CraftARSDKException;
import org.json.JSONObject;
import org.json.JSONException;


public class MyCraftARContentFactory extends CraftARContentFactory {
    @Override
    protected CraftARContent contentFromJSONObject(JSONObject object) throws CraftARSDKException{
        boolean type = true;
        int type1 = CraftARContent.contentTypeFromJSON(object);
        Object content = null;
        switch(type1){
            case CraftARContent.ContentType.CONTENT_TYPE_VIDEO:
                String video_url = object.optString("video_url");
                if(video_url!=null && !video_url.isEmpty()) {
                    if (video_url.contains("compressed_stacked.mp4")) {
                        try {
                            object.put("transparency_mask", true);
                        } catch (JSONException e) {
                        }
                    }
                }
                content = super.contentFromJSONObject(object);
                break;
            default:
                content = super.contentFromJSONObject(object);
        }
        return (CraftARContent)content;
    }
}