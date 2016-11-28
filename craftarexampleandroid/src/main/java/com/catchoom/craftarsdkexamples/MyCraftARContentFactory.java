// com.craftar.craftarexamples is free software. You may use it under the MIT license, which is copied
// below and available at http://opensource.org/licenses/MIT
//
// Copyright (c) 2014 Catchoom Technologies S.L.
//
// Permission is hereby granted, free of charge, to any person obtaining a copy of
// this software and associated documentation files (the "Software"), to deal in
// the Software without restriction, including without limitation the rights to use,
// copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the
// Software, and to permit persons to whom the Software is furnished to do so, subject to
// the following conditions:
//
// The above copyright notice and this permission notice shall be included in all
// copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
// INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
// PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE
// FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
// OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
// DEALINGS IN THE SOFTWARE.

package com.catchoom.craftarsdkexamples;

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
