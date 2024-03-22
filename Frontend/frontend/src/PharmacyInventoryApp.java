import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PharmacyInventoryApp extends JFrame {

    private final DefaultTableModel model;

    public PharmacyInventoryApp() {
        setTitle("Pharmacy Inventory");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        model = new DefaultTableModel();
        model.addColumn("Nazwa leku");
        model.addColumn("Data ważności");
        model.addColumn("Ilość opakowań");

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
        fetchInventory();

        JButton refreshButton = new JButton("Odśwież");
        refreshButton.addActionListener(e -> fetchInventory());
        add(refreshButton, BorderLayout.SOUTH);
    }

    private void fetchInventory() {
        String url = "http://localhost:8080/getAllMedicines";

        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                StringBuilder response = new StringBuilder();
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                JSONArray jsonArray = new JSONArray(response.toString());
                model.setRowCount(0);

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String nazwaLeku = jsonObject.getString("name");
                    String dataWaznosci = jsonObject.getString("date");
                    int iloscOpakowan = jsonObject.getInt("amount");

                    model.addRow(new Object[]{nazwaLeku, dataWaznosci, iloscOpakowan});
                }
            } else {
                System.out.println("Błąd podczas pobierania danych z serwera. Kod odpowiedzi: " + responseCode);
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PharmacyInventoryApp app = new PharmacyInventoryApp();
            app.setVisible(true);
        });
    }
}