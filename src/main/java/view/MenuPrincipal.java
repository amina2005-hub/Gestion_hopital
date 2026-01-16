package view;

import controller.HopitalManager;
import model.*;
import utils.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {

    private HopitalManager manager;
    private Scanner scanner = new Scanner(System.in);

    public MenuPrincipal(HopitalManager manager) {
        this.manager = manager;
    }

    public void afficherMenu() {

        boolean quitter = false;

        while (!quitter) {
            System.out.println("\n===== SYSTÈME HOSPITALIER COMPLET =====");
            System.out.println("========== GESTION DES PATIENTS ==========");
            System.out.println("1. Ajouter patient");
            System.out.println("2. Rechercher patient");
            System.out.println("3. Modifier patient");
            System.out.println("4. Lister tous les patients");

            System.out.println("\n========== DOSSIERS MÉDICAUX ==========");
            System.out.println("5. Consulter dossier médical");
            System.out.println("6. Ajouter note médicale");
            System.out.println("7. Générer rapport médical");
            System.out.println("8. Historique médical complet");

            System.out.println("\n========== GESTION DU PERSONNEL ==========");
            System.out.println("9. Ajouter personnel");
            System.out.println("10. Rechercher personnel");
            System.out.println("11. Lister tout le personnel");

            System.out.println("\n========== RENDEZ-VOUS ==========");
            System.out.println("12. Planifier rendez-vous");
            System.out.println("13. Annuler rendez-vous");
            System.out.println("14. Reporter rendez-vous");
            System.out.println("15. Lister tous les rendez-vous");
            System.out.println("16. Rendez-vous par patient");
            System.out.println("17. Rendez-vous par médecin");

            System.out.println("\n========== PHARMACIE ==========");
            System.out.println("18. Ajouter médicament");
            System.out.println("19. Vérifier stock médicaments");
            System.out.println("20. Prescrire médicament");
            System.out.println("21. Commander médicament");
            System.out.println("22. Lister tous les médicaments");

            System.out.println("\n========== FACTURATION ==========");
            System.out.println("23. Créer facture");
            System.out.println("24. Lister factures");
            System.out.println("25. Factures par patient");
            System.out.println("26. Statistiques financières");

            System.out.println("\n========== URGENCES ==========");
            System.out.println("27. Enregistrer urgence");
            System.out.println("28. Liste des urgences");

            System.out.println("\n========== CHAMBRES & LITS ==========");
            System.out.println("29. Ajouter chambre");
            System.out.println("30. Ajouter lit");
            System.out.println("31. État des chambres");
            System.out.println("32. État des lits");

            System.out.println("\n========== RAPPORTS ==========");
            System.out.println("33. Rapport journalier");
            System.out.println("34. Rapport mensuel");
            System.out.println("35. Statistiques hospitalières");

            System.out.println("\n========== SYSTÈME ==========");
            System.out.println("0. Quitter");
            System.out.print("\nVotre choix : ");

            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1 -> ajouterPatient();
                case 2 -> rechercherPatient();
                case 3 -> modifierPatient();
                case 4 -> listerPatients();
                case 5 -> consulterDossierMedical();
                case 6 -> ajouterNoteMedicale();
                case 7 -> genererRapportMedical();
                case 8 -> historiqueMedicalComplet();
                case 9 -> ajouterPersonnel();
                case 10 -> rechercherPersonnel();
                case 11 -> listerPersonnel();
                case 12 -> planifierRendezVous();
                case 13 -> annulerRendezVous();
                case 14 -> reporterRendezVous();
                case 15 -> listerTousRendezVous();
                case 16 -> rendezVousParPatient();
                case 17 -> rendezVousParMedecin();
                case 18 -> ajouterMedicament();
                case 19 -> verifierStockMedicaments();
                case 20 -> prescrireMedicament();
                case 21 -> commanderMedicament();
                case 22 -> listerMedicaments();
                case 23 -> creerFacture();
                case 24 -> listerFactures();
                case 25 -> facturesParPatient();
                case 26 -> statistiquesFinancieres();
                case 27 -> enregistrerUrgence();
                case 28 -> listerUrgences();
                case 29 -> ajouterChambre();
                case 30 -> ajouterLit();
                case 31 -> etatChambres();
                case 32 -> etatLits();
                case 33 -> rapportJournalier();
                case 34 -> rapportMensuel();
                case 35 -> statistiquesHospitalieres();
                case 0 -> quitter = true;
                default -> System.out.println("❌ Choix invalide");
            }
        }
        System.out.println("\n👋 Au revoir ! Système hospitalier arrêté.");
    }

    // ================= PATIENTS =================
    private void ajouterPatient() {
        System.out.println("\n--- AJOUTER UN PATIENT ---");
        System.out.print("ID : ");
        String id = scanner.nextLine();
        System.out.print("Nom : ");
        String nom = scanner.nextLine();
        System.out.print("Prénom : ");
        String prenom = scanner.nextLine();
        System.out.print("Date de naissance (AAAA-MM-JJ) : ");
        String dateNaissance = scanner.nextLine();
        System.out.print("Numéro de téléphone : ");
        String telephone = scanner.nextLine();
        System.out.print("Adresse : ");
        String adresse = scanner.nextLine();
        System.out.print("Type d'assurance (standard/premium) : ");
        String assurance = scanner.nextLine();
        System.out.print("Groupe sanguin : ");
        String groupeSanguin = scanner.nextLine();
        System.out.print("Allergies connues : ");
        String allergies = scanner.nextLine();
        System.out.print("Antécédents médicaux : ");
        String antecedents = scanner.nextLine();

        Patient patient = new Patient(id, nom, prenom, dateNaissance, assurance);
        patient.setTelephone(telephone);
        patient.setAdresse(adresse);
        patient.setGroupeSanguin(groupeSanguin);
        patient.setAllergies(allergies);
        patient.setAntecedents(antecedents);

        // Créer le dossier médical associé
        DossierMedical dossier = new DossierMedical(patient);
        manager.ajouterDossierMedical(dossier);

        manager.ajouterPatient(patient);
        System.out.println("✅ Patient ajouté avec succès !");
    }

    private void rechercherPatient() {
        System.out.print("\nID du patient : ");
        String id = scanner.nextLine();
        Patient patient = manager.getPatientById(id);

        if (patient != null) {
            System.out.println("\n=== INFORMATIONS PATIENT ===");
            System.out.println("ID: " + patient.getId());
            System.out.println("Nom complet: " + patient.getNom() + " " + patient.getPrenom());
            System.out.println("Date naissance: " + patient.getDateNaissance());
            System.out.println("Assurance: " + patient.getAssurance());
            System.out.println("Téléphone: " + patient.getTelephone());
            System.out.println("Adresse: " + patient.getAdresse());
            System.out.println("Groupe sanguin: " + patient.getGroupeSanguin());
            System.out.println("Allergies: " + patient.getAllergies());
            System.out.println("Antécédents: " + patient.getAntecedents());
        } else {
            System.out.println("❌ Patient non trouvé");
        }
    }

    private void modifierPatient() {
        System.out.print("\nID du patient à modifier : ");
        String id = scanner.nextLine();
        Patient patient = manager.getPatientById(id);

        if (patient != null) {
            System.out.println("\n--- MODIFICATION PATIENT ---");
            System.out.print("Nouveau téléphone (actuel: " + patient.getTelephone() + ") : ");
            String tel = scanner.nextLine();
            if (!tel.isEmpty()) patient.setTelephone(tel);

            System.out.print("Nouvelle adresse (actuelle: " + patient.getAdresse() + ") : ");
            String adr = scanner.nextLine();
            if (!adr.isEmpty()) patient.setAdresse(adr);

            System.out.print("Nouvelle assurance (actuelle: " + patient.getAssurance() + ") : ");
            String ass = scanner.nextLine();
            if (!ass.isEmpty()) patient.setAssurance(ass);

            System.out.println("✅ Patient modifié avec succès");
        } else {
            System.out.println("❌ Patient non trouvé");
        }
    }

    private void listerPatients() {
        System.out.println("\n=== LISTE DES PATIENTS ===");
        List<Patient> patients = manager.getTousPatients();
        if (patients.isEmpty()) {
            System.out.println("Aucun patient enregistré");
        } else {
            for (Patient p : patients) {
                System.out.printf("ID: %s | Nom: %s %s | Assurance: %s | Tél: %s%n",
                        p.getId(), p.getNom(), p.getPrenom(), p.getAssurance(), p.getTelephone());
            }
        }
    }

    // ================= DOSSIERS MÉDICAUX =================
    private void consulterDossierMedical() {
        System.out.print("\nID du patient : ");
        String id = scanner.nextLine();
        DossierMedical dossier = manager.getDossierMedical(id);

        if (dossier != null) {
            System.out.println("\n=== DOSSIER MÉDICAL ===");
            System.out.println("Patient: " + dossier.getPatient().getNom() + " " + dossier.getPatient().getPrenom());
            System.out.println("\n--- HISTORIQUE MÉDICAL ---");
            List<String> notes = dossier.getHistoriques();
            if (notes.isEmpty()) {
                System.out.println("Aucune note médicale enregistrée");
            } else {
                for (int i = 0; i < notes.size(); i++) {
                    System.out.println((i+1) + ". " + notes.get(i));
                }
            }

            // Afficher les rendez-vous du patient
            System.out.println("\n--- RENDEZ-VOUS PASSÉS ---");
            List<RendezVous> rdvs = dossier.getPatient().getHistoriqueRendezVous();
            for (RendezVous rdv : rdvs) {
                if (rdv.getEtat() == EtatRendezVous.TERMINE) {
                    System.out.println("- " + rdv.getDate() + " avec Dr. " + rdv.getMedecin().getNom());
                }
            }
        } else {
            System.out.println("❌ Dossier médical non trouvé");
        }
    }

    private void ajouterNoteMedicale() {
        System.out.print("\nID du patient : ");
        String id = scanner.nextLine();
        DossierMedical dossier = manager.getDossierMedical(id);

        if (dossier != null) {
            System.out.println("\n--- AJOUTER NOTE MÉDICALE ---");
            System.out.println("Date de la consultation (AAAA-MM-JJ) : ");
            String date = scanner.nextLine();
            System.out.println("Médecin traitant : ");
            String medecin = scanner.nextLine();
            System.out.println("Motif de consultation : ");
            String motif = scanner.nextLine();
            System.out.println("Diagnostic : ");
            String diagnostic = scanner.nextLine();
            System.out.println("Traitement prescrit : ");
            String traitement = scanner.nextLine();
            System.out.println("Observations : ");
            String observations = scanner.nextLine();

            String note = String.format("Date: %s | Médecin: %s | Motif: %s | Diagnostic: %s | Traitement: %s | Obs: %s",
                    date, medecin, motif, diagnostic, traitement, observations);

            dossier.ajouterNote(note);
            System.out.println("✅ Note médicale ajoutée avec succès");
        } else {
            System.out.println("❌ Dossier médical non trouvé");
        }
    }

    private void genererRapportMedical() {
        System.out.print("\nID du patient : ");
        String id = scanner.nextLine();
        Patient patient = manager.getPatientById(id);

        if (patient != null) {
            DossierMedical dossier = manager.getDossierMedical(id);
            if (dossier != null) {
                String rapport = "=== RAPPORT MÉDICAL COMPLET ===\n" +
                        "Patient: " + patient.getNom() + " " + patient.getPrenom() + "\n" +
                        "Date naissance: " + patient.getDateNaissance() + "\n" +
                        "Groupe sanguin: " + patient.getGroupeSanguin() + "\n" +
                        "Allergies: " + patient.getAllergies() + "\n" +
                        "Antécédents: " + patient.getAntecedents() + "\n\n" +
                        "=== HISTORIQUE DES CONSULTATIONS ===\n";

                List<String> notes = dossier.getHistoriques();
                for (String note : notes) {
                    rapport += "- " + note + "\n";
                }

                Rapport rapportObj = new Rapport(rapport);
                manager.ajouterRapport(rapportObj);
                System.out.println("📋 Rapport généré avec succès !");
                System.out.println(rapport);
            }
        } else {
            System.out.println("❌ Patient non trouvé");
        }
    }

    private void historiqueMedicalComplet() {
        System.out.print("\nID du patient : ");
        String id = scanner.nextLine();
        Patient patient = manager.getPatientById(id);

        if (patient != null) {
            System.out.println("\n=== HISTORIQUE MÉDICAL COMPLET ===");
            System.out.println("Patient: " + patient.getNom() + " " + patient.getPrenom());

            // Rendez-vous
            System.out.println("\n--- RENDEZ-VOUS ---");
            for (RendezVous rdv : patient.getHistoriqueRendezVous()) {
                System.out.println(rdv.getDate() + " - Dr. " + rdv.getMedecin().getNom() +
                        " - État: " + rdv.getEtat());
            }

            // Factures
            System.out.println("\n--- FACTURES ---");
            for (Facture f : manager.getFacturesParPatient(id)) {
                System.out.println("Facture " + f.getId() + " - Total: " + f.calculerTotal());
            }

            // Dossier médical
            DossierMedical dossier = manager.getDossierMedical(id);
            if (dossier != null) {
                System.out.println("\n--- NOTES MÉDICALES ---");
                for (String note : dossier.getHistoriques()) {
                    System.out.println("- " + note);
                }
            }
        } else {
            System.out.println("❌ Patient non trouvé");
        }
    }

    // ================= PERSONNEL =================
    private void ajouterPersonnel() {
        System.out.println("\n--- AJOUTER PERSONNEL ---");
        System.out.print("Type (Medecin/Infirmier/Pharmacien) : ");
        String type = scanner.nextLine();
        System.out.print("ID : ");
        String id = scanner.nextLine();
        System.out.print("Nom : ");
        String nom = scanner.nextLine();
        System.out.print("Prénom : ");
        String prenom = scanner.nextLine();
        System.out.print("Email : ");
        String email = scanner.nextLine();
        System.out.print("Téléphone : ");
        String telephone = scanner.nextLine();
        System.out.print("Date d'embauche (AAAA-MM-JJ) : ");
        String dateEmbauche = scanner.nextLine();

        String spec = "", inpe = "";
        if (type.equalsIgnoreCase("Medecin")) {
            System.out.print("Spécialité : ");
            spec = scanner.nextLine();
            System.out.print("Numéro INPE : ");
            inpe = scanner.nextLine();
        }

        PersonnelMedical personnel = FactoryPersonnel.creerPersonnel(
                type, id, nom, prenom, email, spec, inpe);

        personnel.setTelephone(telephone);
        personnel.setDateEmbauche(dateEmbauche);

        manager.ajouterPersonnel(personnel);
        System.out.println("✅ Personnel ajouté avec succès");
    }

    private void rechercherPersonnel() {
        System.out.print("\nID du personnel : ");
        String id = scanner.nextLine();
        PersonnelMedical personnel = manager.getPersonnelById(id);

        if (personnel != null) {
            System.out.println("\n=== INFORMATIONS PERSONNEL ===");
            System.out.println("ID: " + personnel.getId());
            System.out.println("Nom: " + personnel.getNom() + " " + personnel.getPrenom());
            System.out.println("Email: " + personnel.getEmail());
            System.out.println("Téléphone: " + personnel.getTelephone());
            System.out.println("Date embauche: " + personnel.getDateEmbauche());

            if (personnel instanceof Medecin) {
                Medecin med = (Medecin) personnel;
                System.out.println("Spécialité: " + med.getSpecialite());
                System.out.println("INPE: " + med.getNumeroINPE());
            } else if (personnel instanceof Infirmier) {
                System.out.println("Fonction: Infirmier");
            } else if (personnel instanceof Pharmacien) {
                System.out.println("Fonction: Pharmacien");
            }
        } else {
            System.out.println("❌ Personnel non trouvé");
        }
    }

    private void listerPersonnel() {
        System.out.println("\n=== LISTE DU PERSONNEL ===");
        List<PersonnelMedical> personnelList = manager.getToutPersonnel();

        System.out.println("\n--- MÉDECINS ---");
        for (PersonnelMedical p : personnelList) {
            if (p instanceof Medecin) {
                Medecin m = (Medecin) p;
                System.out.printf("ID: %s | Dr. %s %s | %s | INPE: %s%n",
                        m.getId(), m.getNom(), m.getPrenom(), m.getSpecialite(), m.getNumeroINPE());
            }
        }

        System.out.println("\n--- INFIRMIERS ---");
        for (PersonnelMedical p : personnelList) {
            if (p instanceof Infirmier) {
                System.out.printf("ID: %s | %s %s%n",
                        p.getId(), p.getNom(), p.getPrenom());
            }
        }

        System.out.println("\n--- PHARMACIENS ---");
        for (PersonnelMedical p : personnelList) {
            if (p instanceof Pharmacien) {
                System.out.printf("ID: %s | %s %s%n",
                        p.getId(), p.getNom(), p.getPrenom());
            }
        }
    }

    // ================= RENDEZ-VOUS =================
    private void planifierRendezVous() {
        System.out.println("\n--- PLANIFIER RENDEZ-VOUS ---");
        System.out.print("ID RV : ");
        String id = scanner.nextLine();
        System.out.print("ID Patient : ");
        String pid = scanner.nextLine();
        System.out.print("ID Médecin : ");
        String mid = scanner.nextLine();
        System.out.print("Date et heure (yyyy-MM-dd HH:mm) : ");

        LocalDateTime date = LocalDateTime.parse(
                scanner.nextLine(),
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
        );

        System.out.print("Motif de consultation : ");
        String motif = scanner.nextLine();
        System.out.print("Durée estimée (minutes) : ");
        int duree = scanner.nextInt();
        scanner.nextLine();

        Patient p = manager.getPatientById(pid);
        PersonnelMedical m = manager.getPersonnelById(mid);

        if (p != null && m instanceof Medecin) {
            RendezVous rv = FactoryRendezVous.creerRendezVous(
                    "consultation", id, p, (Medecin) m, date
            );
            rv.setMotif(motif);
            rv.setDuree(duree);

            manager.planifierRendezVous(rv);

            // Ajouter au dossier médical
            DossierMedical dossier = manager.getDossierMedical(pid);
            if (dossier != null) {
                String note = "Rendez-vous planifié: " + date + " avec Dr. " + m.getNom() +
                        " | Motif: " + motif;
                dossier.ajouterNote(note);
            }

            System.out.println("✅ Rendez-vous planifié avec succès");

            // Envoyer notification
            new NotificationRappel(p.getTelephone()).notifier(
                    "Rappel: RDV le " + date + " avec Dr. " + m.getNom()
            );
        } else {
            System.out.println("❌ Patient ou médecin non trouvé");
        }
    }

    private void annulerRendezVous() {
        System.out.print("\nID du rendez-vous à annuler : ");
        String id = scanner.nextLine();

        for (RendezVous rv : manager.getRendezVous()) {
            if (rv.getId().equals(id)) {
                new AnnulerRendezVous(rv).executer();

                // Mettre à jour le dossier médical
                DossierMedical dossier = manager.getDossierMedical(rv.getPatient().getId());
                if (dossier != null) {
                    dossier.ajouterNote("Rendez-vous annulé: " + rv.getDate() +
                            " avec Dr. " + rv.getMedecin().getNom());
                }
                return;
            }
        }
        System.out.println("❌ Rendez-vous introuvable");
    }

    private void reporterRendezVous() {
        System.out.print("\nID du rendez-vous à reporter : ");
        String id = scanner.nextLine();

        for (RendezVous rv : manager.getRendezVous()) {
            if (rv.getId().equals(id)) {
                System.out.print("Nouvelle date (yyyy-MM-dd HH:mm) : ");
                LocalDateTime nouvelleDate = LocalDateTime.parse(
                        scanner.nextLine(),
                        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
                );

                rv.setDate(nouvelleDate);
                System.out.println("✅ Rendez-vous reporté au " + nouvelleDate);

                // Notification
                new NotificationRappel(rv.getPatient().getTelephone()).notifier(
                        "RDV reporté au " + nouvelleDate
                );
                return;
            }
        }
        System.out.println("❌ Rendez-vous introuvable");
    }

    private void listerTousRendezVous() {
        System.out.println("\n=== TOUS LES RENDEZ-VOUS ===");
        List<RendezVous> rdvs = manager.getRendezVous();

        System.out.println("\n--- PLANIFIÉS ---");
        for (RendezVous rv : rdvs) {
            if (rv.getEtat() == EtatRendezVous.PLANIFIE) {
                System.out.printf("%s | Patient: %s | Dr: %s | %s | Motif: %s%n",
                        rv.getId(), rv.getPatient().getNom(), rv.getMedecin().getNom(),
                        rv.getDate(), rv.getMotif());
            }
        }

        System.out.println("\n--- TERMINÉS ---");
        for (RendezVous rv : rdvs) {
            if (rv.getEtat() == EtatRendezVous.TERMINE) {
                System.out.printf("%s | Patient: %s | Dr: %s | %s%n",
                        rv.getId(), rv.getPatient().getNom(), rv.getMedecin().getNom(),
                        rv.getDate());
            }
        }
    }

    private void rendezVousParPatient() {
        System.out.print("\nID du patient : ");
        String id = scanner.nextLine();
        Patient patient = manager.getPatientById(id);

        if (patient != null) {
            System.out.println("\n=== RENDEZ-VOUS DE " + patient.getNom().toUpperCase() + " ===");
            for (RendezVous rv : patient.getHistoriqueRendezVous()) {
                System.out.printf("%s | Dr: %s | %s | État: %s | Motif: %s%n",
                        rv.getId(), rv.getMedecin().getNom(), rv.getDate(),
                        rv.getEtat(), rv.getMotif());
            }
        } else {
            System.out.println("❌ Patient non trouvé");
        }
    }

    private void rendezVousParMedecin() {
        System.out.print("\nID du médecin : ");
        String id = scanner.nextLine();
        PersonnelMedical personnel = manager.getPersonnelById(id);

        if (personnel instanceof Medecin) {
            Medecin medecin = (Medecin) personnel;
            System.out.println("\n=== RENDEZ-VOUS DU DR. " + medecin.getNom().toUpperCase() + " ===");

            for (RendezVous rv : manager.getRendezVous()) {
                if (rv.getMedecin().getId().equals(id)) {
                    System.out.printf("%s | Patient: %s | %s | État: %s%n",
                            rv.getId(), rv.getPatient().getNom(), rv.getDate(), rv.getEtat());
                }
            }
        } else {
            System.out.println("❌ Médecin non trouvé");
        }
    }

    // ================= PHARMACIE =================
    private void ajouterMedicament() {
        System.out.println("\n--- AJOUTER MÉDICAMENT ---");
        System.out.print("Code : ");
        String code = scanner.nextLine();
        System.out.print("Nom : ");
        String nom = scanner.nextLine();
        System.out.print("Laboratoire : ");
        String labo = scanner.nextLine();
        System.out.print("Quantité : ");
        int quantite = scanner.nextInt();
        System.out.print("Prix unitaire : ");
        double prix = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Date de péremption (AAAA-MM-JJ) : ");
        String datePeremption = scanner.nextLine();
        System.out.print("Catégorie (Antibiotique/Antalgique/etc.) : ");
        String categorie = scanner.nextLine();

        Medicament medicament = new Medicament(code, nom, labo, quantite, prix);
        medicament.setDatePeremption(datePeremption);
        medicament.setCategorie(categorie);

        manager.ajouterMedicament(medicament);
        System.out.println("✅ Médicament ajouté au stock");
    }

    private void verifierStockMedicaments() {
        System.out.println("\n=== ÉTAT DU STOCK PHARMACIE ===");
        List<Medicament> medicaments = manager.getMedicaments();

        System.out.println("\n--- STOCK FAIBLE (< 10 unités) ---");
        for (Medicament m : medicaments) {
            if (m.getQuantite() < 10) {
                System.out.printf("⚠ %s | Stock: %d | Seuil: %d%n",
                        m.getNom(), m.getQuantite(), m.getStockMinimum());
            }
        }

        System.out.println("\n--- STOCK NORMAL ---");
        for (Medicament m : medicaments) {
            if (m.getQuantite() >= 10 && m.getQuantite() < 50) {
                System.out.printf("%s | Stock: %d%n", m.getNom(), m.getQuantite());
            }
        }

        System.out.println("\n--- STOCK ÉLEVÉ ---");
        for (Medicament m : medicaments) {
            if (m.getQuantite() >= 50) {
                System.out.printf("%s | Stock: %d%n", m.getNom(), m.getQuantite());
            }
        }
    }

    private void prescrireMedicament() {
        System.out.println("\n--- PRESCRIRE MÉDICAMENT ---");
        System.out.print("ID Patient : ");
        String pid = scanner.nextLine();
        System.out.print("Code médicament : ");
        String code = scanner.nextLine();
        System.out.print("Quantité : ");
        int quantite = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Posologie : ");
        String posologie = scanner.nextLine();
        System.out.print("Durée du traitement (jours) : ");
        int duree = scanner.nextInt();
        scanner.nextLine();

        Patient patient = manager.getPatientById(pid);
        Medicament medicament = manager.getMedicament(code);

        if (patient != null && medicament != null) {
            // Créer la commande de prescription
            Commande prescription = new PrescrireMedicament(medicament, quantite);
            prescription.executer();

            // Ajouter au dossier médical
            DossierMedical dossier = manager.getDossierMedical(pid);
            if (dossier != null) {
                String note = String.format("Prescription: %s x%d | Posologie: %s | Durée: %d jours",
                        medicament.getNom(), quantite, posologie, duree);
                dossier.ajouterNote(note);
            }

            System.out.println("✅ Médicament prescrit avec succès");
        } else {
            System.out.println("❌ Patient ou médicament non trouvé");
        }
    }

    private void commanderMedicament() {
        System.out.println("\n--- COMMANDER MÉDICAMENT ---");
        System.out.print("Code médicament : ");
        String code = scanner.nextLine();
        System.out.print("Quantité à commander : ");
        int quantite = scanner.nextInt();
        scanner.nextLine();

        Medicament medicament = manager.getMedicament(code);
        if (medicament != null) {
            medicament.augmenterStock(quantite);
            System.out.println("✅ Commande effectuée. Nouveau stock: " + medicament.getQuantite());

            // Ajouter à l'historique des commandes
            manager.ajouterCommande("Commande: " + medicament.getNom() +
                    " x" + quantite + " | Date: " + LocalDateTime.now());
        } else {
            System.out.println("❌ Médicament non trouvé");
        }
    }

    private void listerMedicaments() {
        System.out.println("\n=== LISTE DES MÉDICAMENTS ===");
        List<Medicament> medicaments = manager.getMedicaments();

        for (Medicament m : medicaments) {
            System.out.printf("%s | %s | Labo: %s | Stock: %d | Prix: %.2f DH | Cat: %s%n",
                    m.getCode(), m.getNom(), m.getLaboratoire(), m.getQuantite(),
                    m.getPrixUnitaire(), m.getCategorie());
        }
    }

    // ================= FACTURATION =================
    private void creerFacture() {
        System.out.println("\n--- CRÉER FACTURE ---");
        System.out.print("ID Facture : ");
        String id = scanner.nextLine();
        System.out.print("ID Patient : ");
        String pid = scanner.nextLine();

        Patient patient = manager.getPatientById(pid);
        if (patient == null) {
            System.out.println("❌ Patient introuvable");
            return;
        }

        Facture facture = new Facture(id, patient);

        boolean ajouter = true;
        while (ajouter) {
            System.out.println("\nTypes de services :");
            System.out.println("1. Consultation (150 DH)");
            System.out.println("2. Urgence (500 DH)");
            System.out.println("3. Hospitalisation (1000 DH/jour)");
            System.out.println("4. Médicaments");
            System.out.println("5. Analyses");
            System.out.println("0. Terminer");
            System.out.print("Choix : ");
            int choixService = scanner.nextInt();
            scanner.nextLine();

            switch (choixService) {
                case 1 -> {
                    System.out.print("Durée consultation (minutes) : ");
                    int duree = scanner.nextInt();
                    scanner.nextLine();
                    facture.ajouterService(new Consultation(150));
                }
                case 2 -> {
                    System.out.print("Niveau urgence (1-3) : ");
                    int niveau = scanner.nextInt();
                    scanner.nextLine();
                    double prix = niveau == 1 ? 800 : (niveau == 2 ? 500 : 300);
                    facture.ajouterService(new Urgence(prix));
                }
                case 3 -> {
                    System.out.print("Nombre de jours : ");
                    int jours = scanner.nextInt();
                    scanner.nextLine();
                    facture.ajouterService(new Hospitalisation(jours * 1000));
                }
                case 4 -> {
                    System.out.print("Code médicament : ");
                    String code = scanner.nextLine();
                    System.out.print("Quantité : ");
                    int qte = scanner.nextInt();
                    scanner.nextLine();
                    Medicament med = manager.getMedicament(code);
                    if (med != null) {
                        facture.ajouterService(new ServiceMedicament(med, qte));
                    }
                }
                case 0 -> ajouter = false;
                default -> System.out.println("Choix invalide");
            }
        }

        // Appliquer la stratégie de facturation selon l'assurance
        StrategyFacturation strategy = patient.getAssurance().equalsIgnoreCase("premium")
                ? new AssurancePremium()
                : new AssuranceStandard();

        double total = facture.calculerTotal();
        double totalFinal = strategy.appliquerReduction(total);

        manager.ajouterFacture(facture);

        System.out.println("\n=== FACTURE GÉNÉRÉE ===");
        System.out.println("Numéro: " + facture.getId());
        System.out.println("Patient: " + patient.getNom() + " " + patient.getPrenom());
        System.out.println("Date: " + LocalDateTime.now());
        System.out.println("Total brut: " + total + " DH");
        System.out.println("Type assurance: " + patient.getAssurance());
        System.out.println("Réduction appliquée: " + (strategy instanceof AssurancePremium ? "50%" : "20%"));
        System.out.println("TOTAL NET: " + totalFinal + " DH");
        System.out.println("=========================");
    }

    private void listerFactures() {
        System.out.println("\n=== LISTE DES FACTURES ===");
        List<Facture> factures = manager.getFactures();

        for (Facture f : factures) {
            System.out.printf("Facture %s | Patient: %s | Date: %s | Total: %.2f DH%n",
                    f.getId(), f.getPatient().getNom(), f.getDateCreation(), f.calculerTotal());
        }

        // Total général
        double totalGeneral = factures.stream()
                .mapToDouble(Facture::calculerTotal)
                .sum();
        System.out.println("\n💰 TOTAL GÉNÉRAL: " + totalGeneral + " DH");
    }

    private void facturesParPatient() {
        System.out.print("\nID Patient : ");
        String id = scanner.nextLine();

        System.out.println("\n=== FACTURES DU PATIENT ===");
        List<Facture> factures = manager.getFacturesParPatient(id);

        if (factures.isEmpty()) {
            System.out.println("Aucune facture trouvée");
        } else {
            for (Facture f : factures) {
                System.out.printf("Facture %s | Date: %s | Total: %.2f DH | Statut: %s%n",
                        f.getId(), f.getDateCreation(), f.calculerTotal(), f.getStatut());
            }

            double totalPatient = factures.stream()
                    .mapToDouble(Facture::calculerTotal)
                    .sum();
            System.out.println("\nTotal patient: " + totalPatient + " DH");
        }
    }

    private void statistiquesFinancieres() {
        System.out.println("\n=== STATISTIQUES FINANCIÈRES ===");
        List<Facture> factures = manager.getFactures();

        double total = 0;
        int nbFactures = factures.size();
        double moyenne = 0;

        if (!factures.isEmpty()) {
            total = factures.stream().mapToDouble(Facture::calculerTotal).sum();
            moyenne = total / nbFactures;
        }

        System.out.println("Nombre total de factures: " + nbFactures);
        System.out.println("Chiffre d'affaires total: " + total + " DH");
        System.out.println("Moyenne par facture: " + moyenne + " DH");

        // Par type d'assurance
        long nbPremium = manager.getPatients().stream()
                .filter(p -> p.getAssurance().equalsIgnoreCase("premium"))
                .count();
        long nbStandard = manager.getPatients().stream()
                .filter(p -> p.getAssurance().equalsIgnoreCase("standard"))
                .count();

        System.out.println("\nRépartition assurances:");
        System.out.println("- Premium: " + nbPremium + " patients");
        System.out.println("- Standard: " + nbStandard + " patients");
    }

    // ================= URGENCES =================
    private void enregistrerUrgence() {
        System.out.println("\n--- ENREGISTRER URGENCE ---");
        System.out.print("ID Urgence : ");
        String id = scanner.nextLine();
        System.out.print("ID Patient : ");
        String pid = scanner.nextLine();
        System.out.print("Niveau (1-Critique, 2-Urgent, 3-Moyen) : ");
        int niveau = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Symptômes : ");
        String symptomes = scanner.nextLine();
        System.out.print("Médecin traitant ID : ");
        String mid = scanner.nextLine();

        Patient patient = manager.getPatientById(pid);
        PersonnelMedical medecin = manager.getPersonnelById(mid);

        if (patient != null && medecin instanceof Medecin) {
            Urgence urgence = new Urgence(id, patient, (Medecin) medecin, niveau, symptomes);
            manager.ajouterUrgence(urgence);

            // Ajouter au dossier médical
            DossierMedical dossier = manager.getDossierMedical(pid);
            if (dossier != null) {
                dossier.ajouterNote("URGENCE: " + LocalDateTime.now() +
                        " | Niveau: " + niveau +
                        " | Symptômes: " + symptomes +
                        " | Traité par: Dr. " + medecin.getNom());
            }

            System.out.println("✅ Urgence enregistrée. Priorité: " +
                    (niveau == 1 ? "CRITIQUE" : niveau == 2 ? "URGENT" : "MOYEN"));
        } else {
            System.out.println("❌ Patient ou médecin non trouvé");
        }
    }

    private void listerUrgences() {
        System.out.println("\n=== LISTE DES URGENCES ===");
        List<Urgence> urgences = manager.getUrgences();

        System.out.println("\n--- EN COURS ---");
        for (Urgence u : urgences) {
            if (!u.isTraitee()) {
                System.out.printf("%s | Patient: %s | Niveau: %d | Symptômes: %s%n",
                        u.getId(), u.getPatient().getNom(), u.getNiveau(), u.getSymptomes());
            }
        }

        System.out.println("\n--- TRAITÉES ---");
        for (Urgence u : urgences) {
            if (u.isTraitee()) {
                System.out.printf("%s | Patient: %s | Traitée le: %s%n",
                        u.getId(), u.getPatient().getNom(), u.getDateTraitement());
            }
        }
    }

    // ================= CHAMBRES & LITS =================
    private void ajouterChambre() {
        System.out.print("\nNuméro de chambre : ");
        int numero = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nombre de lits : ");
        int nbLits = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Type (Standard/VIP/Soins intensifs) : ");
        String type = scanner.nextLine();

        Chambre chambre = new Chambre(numero, nbLits, type);
        manager.ajouterChambre(chambre);
        System.out.println("✅ Chambre ajoutée");
    }

    private void ajouterLit() {
        System.out.print("\nNuméro de chambre : ");
        int numChambre = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Numéro de lit : ");
        int numLit = scanner.nextInt();
        scanner.nextLine();

        Lit lit = new Lit(numLit);
        manager.ajouterLit(numChambre, lit);
        System.out.println("✅ Lit ajouté");
    }

    private void etatChambres() {
        System.out.println("\n=== ÉTAT DES CHAMBRES ===");
        List<Chambre> chambres = manager.getChambres();

        for (Chambre c : chambres) {
            System.out.printf("Chambre %d | Type: %s | Lits: %d/%d | %s%n",
                    c.getNumero(), c.getType(), c.getLitsOccupees(), c.getNbLits(),
                    c.isDisponible() ? "✅ Disponible" : "⛔ Occupée");
        }
    }

    private void etatLits() {
        System.out.println("\n=== ÉTAT DES LITS ===");
        List<Lit> lits = manager.getLits();

        System.out.println("\n--- LITS OCCUPÉS ---");
        for (Lit l : lits) {
            if (l.isOccupe()) {
                System.out.printf("Lit %d | Chambre: %d | Patient: %s%n",
                        l.getNumero(), l.getNumeroChambre(), l.getPatient() != null ?
                                l.getPatient().getNom() : "Inconnu");
            }
        }

        System.out.println("\n--- LITS DISPONIBLES ---");
        for (Lit l : lits) {
            if (!l.isOccupe()) {
                System.out.printf("Lit %d | Chambre: %d%n", l.getNumero(), l.getNumeroChambre());
            }
        }
    }

    // ================= RAPPORTS =================
    private void rapportJournalier() {
        System.out.println("\n=== RAPPORT JOURNALIER ===");
        LocalDateTime aujourdhui = LocalDateTime.now();

        System.out.println("Date: " + aujourdhui.toLocalDate());
        System.out.println("\n--- ACTIVITÉS DU JOUR ---");

        // Rendez-vous du jour
        System.out.println("Rendez-vous prévus:");
        for (RendezVous rv : manager.getRendezVous()) {
            if (rv.getDate().toLocalDate().equals(aujourdhui.toLocalDate())) {
                System.out.println("- " + rv.getDate().toLocalTime() + " | " +
                        rv.getPatient().getNom() + " avec Dr. " + rv.getMedecin().getNom());
            }
        }

        // Urgences du jour
        System.out.println("\nUrgences traitées:");
        for (Urgence u : manager.getUrgences()) {
            if (u.getDateArrivee().toLocalDate().equals(aujourdhui.toLocalDate())) {
                System.out.println("- " + u.getPatient().getNom() + " | Niveau: " + u.getNiveau());
            }
        }

        // Factures du jour
        System.out.println("\nFactures générées:");
        for (Facture f : manager.getFactures()) {
            if (f.getDateCreation().toLocalDate().equals(aujourdhui.toLocalDate())) {
                System.out.println("- Facture " + f.getId() + " | " + f.getPatient().getNom() +
                        " | " + f.calculerTotal() + " DH");
            }
        }
    }

    private void rapportMensuel() {
        System.out.println("\n=== RAPPORT MENSUEL ===");
        LocalDateTime maintenant = LocalDateTime.now();
        int mois = maintenant.getMonthValue();
        int annee = maintenant.getYear();

        System.out.println("Période: " + mois + "/" + annee);

        // Statistiques
        int nbPatients = manager.getPatients().size();
        int nbRendezVous = (int) manager.getRendezVous().stream()
                .filter(rv -> rv.getDate().getMonthValue() == mois && rv.getDate().getYear() == annee)
                .count();
        int nbUrgences = (int) manager.getUrgences().stream()
                .filter(u -> u.getDateArrivee().getMonthValue() == mois && u.getDateArrivee().getYear() == annee)
                .count();

        double revenus = manager.getFactures().stream()
                .filter(f -> f.getDateCreation().getMonthValue() == mois && f.getDateCreation().getYear() == annee)
                .mapToDouble(Facture::calculerTotal)
                .sum();

        System.out.println("\n📊 STATISTIQUES:");
        System.out.println("Patients totaux: " + nbPatients);
        System.out.println("Rendez-vous ce mois: " + nbRendezVous);
        System.out.println("Urgences ce mois: " + nbUrgences);
        System.out.println("Revenus ce mois: " + revenus + " DH");

        // Médicaments les plus utilisés
        System.out.println("\n💊 MÉDICAMENTS PRESCRITS:");
        // Logique pour les médicaments prescrits...
    }

    private void statistiquesHospitalieres() {
        System.out.println("\n=== STATISTIQUES HOSPITALIÈRES ===");

        int totalPatients = manager.getPatients().size();
        int totalPersonnel = manager.getToutPersonnel().size();
        int totalRendezVous = manager.getRendezVous().size();
        int totalUrgences = manager.getUrgences().size();
        int totalFactures = manager.getFactures().size();

        System.out.println("👥 PATIENTS: " + totalPatients);
        System.out.println("👨‍⚕️ PERSONNEL: " + totalPersonnel);
        System.out.println("📅 RENDEZ-VOUS: " + totalRendezVous);
        System.out.println("🚨 URGENCES: " + totalUrgences);
        System.out.println("💰 FACTURES: " + totalFactures);

        // Taux d'occupation
        int litsTotaux = manager.getLits().size();
        int litsOccupes = (int) manager.getLits().stream()
                .filter(Lit::isOccupe)
                .count();
        double tauxOccupation = litsTotaux > 0 ? (litsOccupes * 100.0 / litsTotaux) : 0;

        System.out.println("\n🏥 OCCUPATION:");
        System.out.println("Lits occupés: " + litsOccupes + "/" + litsTotaux);
        System.out.println("Taux d'occupation: " + String.format("%.1f", tauxOccupation) + "%");

        // Répartition du personnel
        long nbMedecins = manager.getToutPersonnel().stream()
                .filter(p -> p instanceof Medecin)
                .count();
        long nbInfirmiers = manager.getToutPersonnel().stream()
                .filter(p -> p instanceof Infirmier)
                .count();
        long nbPharmaciens = manager.getToutPersonnel().stream()
                .filter(p -> p instanceof Pharmacien)
                .count();

        System.out.println("\n👨‍⚕️ RÉPARTITION PERSONNEL:");
        System.out.println("Médecins: " + nbMedecins);
        System.out.println("Infirmiers: " + nbInfirmiers);
        System.out.println("Pharmaciens: " + nbPharmaciens);
    }
}