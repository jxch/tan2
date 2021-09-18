package xyz.jxch.tan.grafana.service;

import lombok.extern.slf4j.Slf4j;
import oracle.jdbc.OracleConnection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RestController;
import xyz.jxch.tan.grafana.OracleCloudJson;

import javax.sql.DataSource;
import javax.validation.constraints.NotNull;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

@Slf4j
@RestController
public class OracleCloudJsonService implements OracleCloudJson {
    private final DataSource dataSource;

    public OracleCloudJsonService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public String select(String sql) {
        log.info(sql);
        try (OracleConnection connection = (OracleConnection) dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            return rsToJson(resultSet);
        } catch (SQLException | JSONException exception) {
            exception.printStackTrace();return exception.toString();
        }
    }

    private String rsToJson(@NotNull ResultSet resultSet) throws SQLException, JSONException {
        JSONArray jsonArray = new JSONArray();
        while (resultSet.next()) {
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            JSONObject jsonObj = new JSONObject();
            // 遍历每一列
            for (int i = 1; i <= columnCount; i++) {
                String columnName = metaData.getColumnLabel(i);
                String value = resultSet.getString(columnName);
                jsonObj.put(columnName, value);
            }
            jsonArray.put(jsonObj);
        }

        return jsonArray.toString();
    }
}
