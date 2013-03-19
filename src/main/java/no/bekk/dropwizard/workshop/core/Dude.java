package no.bekk.dropwizard.workshop.core;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.jongo.marshall.jackson.id.Id;

/**
 * @author Mikael Vik (BEKK) - mikael.vik@bekk.no
 */
@SuppressWarnings("UnusedDeclaration")
public class Dude {

    @Id @JsonIgnore private String id;
    private String name;
    private Long skill;
    private Date employed_since;
    private List<String> famous_for;
    private Map<String, String> info;

    public Dude() {
        // keep this if you want Jackson to work...
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSkill() {
        return skill;
    }

    public Date getEmployed_since() {
        return employed_since;
    }

    public List<String> getFamous_for() {
        return famous_for;
    }

    public Map<String, String> getInfo() {
        return info;
    }

    @Override public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
