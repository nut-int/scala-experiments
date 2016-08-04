package experiment

trait Experiment {
    def experimentName: String
    def experimentDesc: String
    def beginExperiment(): Unit
}
