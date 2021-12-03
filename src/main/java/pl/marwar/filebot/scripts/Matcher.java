package pl.marwar.filebot.scripts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode
@AllArgsConstructor
public class Matcher implements Serializable {

    private final static long serialVersionUID = 4321517773106221920L;
    @SerializedName("matcherRule")
    @Expose
    private String matcherRule;
    @SerializedName("param")
    @Expose
    private String param;


}