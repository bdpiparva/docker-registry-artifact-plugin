/*
 * Copyright 2018 ThoughtWorks, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cd.go.artifact.docker.model;

import cd.go.artifact.docker.annotation.ProfileField;
import cd.go.artifact.docker.annotation.Validatable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import static cd.go.artifact.docker.utils.Util.GSON;

public class ArtifactStoreConfig implements Validatable {
    @Expose
    @SerializedName("RegistryURL")
    @ProfileField(key = "RegistryURL", required = true, secure = false)
    private String registryUrl;

    @Expose
    @SerializedName("Username")
    @ProfileField(key = "Username", required = true, secure = false)
    private String username;

    @Expose
    @SerializedName("Password")
    @ProfileField(key = "Password", required = true, secure = true)
    private String password;


    public ArtifactStoreConfig() {
    }

    public ArtifactStoreConfig(String registryUrl,String username, String password) {
        this.registryUrl = registryUrl;
        this.username = username;
        this.password = password;
    }

    public String getRegistryUrl() {
        return registryUrl;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArtifactStoreConfig)) return false;

        ArtifactStoreConfig that = (ArtifactStoreConfig) o;

        if (registryUrl != null ? !registryUrl.equals(that.registryUrl) : that.registryUrl != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        return password != null ? password.equals(that.password) : that.password == null;
    }

    @Override
    public int hashCode() {
        int result = registryUrl != null ? registryUrl.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    public static ArtifactStoreConfig fromJSON(String json) {
        return GSON.fromJson(json, ArtifactStoreConfig.class);
    }
}
